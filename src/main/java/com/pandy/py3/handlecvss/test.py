def get_cvss_score(cvss_info: dict):
    """
    获取cvss_score评分：
    1. 如果同时存在cvss 与 cvss3，将cvss_score更新为cvss3
    2. 如果不存在cvss3，则取cvss，cvss也没有，则取默认值0.0
    """
    zero_value = 0.0
    if isinstance(cvss_info, dict):

        if cvss_info is None or len(cvss_info.keys()) == 0:
            return zero_value
        keys = sorted(cvss_info.keys())
        dic_value = cvss_info[keys[-1]]

        try:
            latest_cvss_score = float(dic_value)
            return latest_cvss_score
        except Exception as e:
            print(e)
            # logging.error("number format exception ")
            return zero_value
    else:
        return zero_value

if __name__ == '__main__':
    cvss_info_one = {

    }

    cvss_info_two = {
        "v2": "2"
    }

    cvss_info_three = {
        "v3": "3"
    }

    cvss_info_four = {
        "v2": "2",
        "v3": "3"
    }

    cvss_info_five = {
        "v4": "4",
        "v3": "3",
        "v2": "2"
    }

    cvss_info_six = {
        "v3": "3",
        "v4": "4",
        "v2": "2"
    }

    cvss_info_seven = {
        "v31": "31",
        "v4": "4",
        "v32": "32"
    }

    cvss_info_eight = {
        "v031": "31",
        "v04": "4",
        "v32": "32"
    }

    cvss_info_nine = {
        "v04": "04",
        "v02": "02",
        "v11": "11"
    }

    cvss_info_ten = {
        "v31": "31",
        "v04": "4",
        "v32": "32"
    }

    assert get_cvss_score(cvss_info_one) == 0.0
    assert get_cvss_score(cvss_info_two) == 2
    assert get_cvss_score(cvss_info_three) == 3
    assert get_cvss_score(cvss_info_four) == 3
    assert get_cvss_score(cvss_info_five) == 4
    assert get_cvss_score(cvss_info_six) == 4
    assert get_cvss_score(cvss_info_seven) == 4
    assert get_cvss_score(cvss_info_eight) == 32
    assert get_cvss_score(cvss_info_nine) == 11
    assert get_cvss_score(cvss_info_ten) == 32
