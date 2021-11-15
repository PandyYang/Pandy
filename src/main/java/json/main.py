import json
import pandas as pd

preheat = 0
refresh = 0
maxDayPre = 0
maxDayRef = 0

def maxSum(arr, k):
    n = len(arr)
    if n < k:
        return -1
    max_sum = 0
    for i in range(k):
        max_sum += arr[i]

    sum = max_sum
    for i in range(k, n):
        # 推入一个元素 移除下一个元素
        sum += arr[i] - arr[i - k]
        max_sum = max(sum, max_sum)
    return max_sum


filename = open(r'/Users/pandy/IdeaProjects/Pandy/src/main/resources/json/cdn.json', encoding='utf-8')
json_data = json.load(filename)
res = []

for k, v in json_data.items():
    dic = json_data[k]
    for k1 in range(len(dic)):
        val = dic[k1]['fileNum']
        # print(val)
        res.append(val)
    # print(dic)
    # print(res)
    # 连续子数组的最大求和
    print("自系统上线来连续30天或某一天的发布和删除最值数据汇总")
    print("----------------发布----------------------")
    print("连续30天最多的cdn发布数: " + str(maxSum(res, 30)))
    print("发布数量最多的一天的数量: " + str(max(res)))
    print("发布数量最多的一天的刷新数量: " + str(max(res)))
    maxDayPre += max(res)
    print("发布数量最多的一天的预热数量: " + str(max(res)))
    maxDayRef += max(res)
    print("连续30天的cdn发布所累积的刷新和预热次数: " + str(maxSum(res, 30) * 2))
    preheat += maxSum(res, 30)
    refresh += maxSum(res, 30)

filename = open(r'/Users/pandy/IdeaProjects/Pandy/src/main/resources/json/delete.json', encoding='utf-8')
json_data2 = json.load(filename)
res = []

for k, v in json_data2.items():
    dic = json_data2[k]
    for k1 in range(len(dic)):
        val = dic[k1]['deleteNum']
        # print(val)
        res.append(val)
    # print(dic)
    # print(res)
    # 连续子数组的最大求和
    print("----------------删除----------------------")
    print("连续30天最多的删除数: " + str(maxSum(res, 30)))
    print("删除数量最多的一天的数量: " + str(max(res)))
    print("连续30天的cdn删除所累积的刷新次数: " + str(maxSum(res, 30)))
    print("删除数量最多的一天的刷新次数: " + str(max(res)))
    maxDayRef += max(res)
    refresh += maxSum(res, 30)
    print("----------------累计---------------------")
    print("连续30内最多的刷新次数为:" + str(refresh))
    print("连续30内最多的预热次数为:" + str(preheat))
    print("----------------总结---------------------")
    print("连续30内最多的预热和刷新次数总计为:" + str(preheat + refresh))
    print("最多一天的刷新次数总计为:" + str(maxDayRef))
    print("最多一天的预热次数总计为:" + str(maxDayPre))
    print("最多一天的预热和刷新次数总计为:" + str(maxDayPre + maxDayRef))
