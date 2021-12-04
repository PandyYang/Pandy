import requests, json, os
from lxml import etree
from multiprocessing.dummy import Pool

index_class = ['4kfengjing', '4kmeinv', '4kyouxi', '4kdongman', '4kyingshi', '4kqiche', '4kdongwu', '4krenwu',
               '4kmeishi', '4kzongjiao', '4kbeijing', '4kmingxing']
print('网站：【吾爱破解 52pojie.cn】  作者：【吾爱论坛总策划】')
# 设置下载分类
while True:
    fenlei = input('【1-风景 2-美女 3-游戏 4-动漫 5-影视 6-汽车 7-动物 8-人物 9-美食 10-宗教 11-背景 12-明星 0-全部】\n请输入下载分类，用空格隔开：').split(' ')
    nub_list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 0]
    index_list = []
    tcxh = True
    # 判断分类列表是否为空
    if not fenlei[0]:
        print('未输入任何分类，请重新输入！')
        continue
    elif fenlei[0] == '0':
        index_list = index_class
        # print(index_list)
        break
    for fl in fenlei:
        fl = int(fl)
        if fl not in nub_list:
            tcxh = False
            print('超出分类选项，请重新输入')
            break
        else:
            index_list.append(index_class[fl - 1])
    if tcxh:
        break
# 设置下载页数
nubmer = int(input('请输入下载页数，填0则全部下载：'))
if nubmer == 0:
    nubmer = 999
elif nubmer <= -1 or nubmer == 1:
    nubmer = 2
# 设置线程数量
pool_po = int(input('请输入线程数，线程越多下载越快，建议为4：'))
if pool_po <= 2:
    pool_po = 2

headers = {
    'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_6) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Safari/605.1.15'
}


# 获取首页响应文本，解析出每张图片详情页地址
def get_home_url(url):
    # 存放所有的图片链接
    img_list = []

    # 获取首页响应文本
    response = requests.get(url=url, headers=headers)
    response.encoding = 'gbk'
    page_text = response.text

    # 解析首页响应文本
    tree = etree.HTML(page_text)
    ul_list = tree.xpath('//div[@class="slist"]/ul[@class="clearfix"]/li')

    # 循环取出列表元素
    for ul in ul_list:
        href = ul.xpath('./a/@href')[0]
        title = ul.xpath('./a/b/text()')[0]

        # 将取出的图片链接和标题，存放到img_list中
        img_list.append({title: href})

    # 判断是否到最后一页，如果最后一页那么一定是空列表
    if len(img_list) > 3:
        return img_list
    else:
        return False


# 获取详情页文本，解析每张图片地址，保存到本地
def get_detail_img(img_list, filePath):
    host_url = 'https://pic.netbian.com'

    # 循环取出图片详情页地址和标题，存放到 i
    for i in img_list:
        title = list(i.keys())[0]
        img_url = host_url + list(i.values())[0]

        # 获取详情页响应文本并解析出图片地址
        page_text = requests.get(img_url, headers=headers).text
        tree = etree.HTML(page_text)
        img_data_url = host_url + tree.xpath(
            '//div[@class="wrap clearfix"]/div[1]/div[@class="photo"]/div[1]/div[@class="photo-pic"]/a/img/@src')[0]

        # 将获取到到图片地址下载保存
        img_data = requests.get(img_data_url, headers=headers).content
        with open(filePath + title + '.jpg', 'wb') as fp:
            fp.write(img_data)
            print(title, '  -----下载完毕！！！')


# 总控
def get_img(url):
    i = 1
    if not os.path.exists(os.getcwd() + '/' + url):
        os.mkdir(url)
    filepath = url + '/'
    with open('./json.json', 'r', encoding='utf8') as fp:
        index = json.load(fp)
    index_url = index[url]
    while True:
        # 下载页数达到则跳出循环
        if i > nubmer:
            break
        home_url = 'https://pic.netbian.com/' + url + '/index_' + str(index_url) + '.html'
        index_url += 1
        index[url] = index_url
        with open('./json.json', 'w', encoding='utf8') as fp:
            json.dump(index, fp=fp, ensure_ascii=False)
        i += 1
        valid = get_home_url(home_url)
        if valid:
            get_detail_img(img_list=valid, filePath=filepath)
        else:
            break


pool = Pool(pool_po)
pool.map(get_img, index_list)
print('——————程序执行完毕——————')
