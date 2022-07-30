def get_cvss_score2(cvss, cvss_v3):

    cvss_exist = cvss is not None and len(cvss.strip()) != 0 and cvss != "0" and cvss != "0.0"
    cvss_v3_exist = cvss_v3 is not None and len(cvss_v3.strip()) != 0 and cvss_v3 != "0" and cvss_v3 != "0.0"

    get_score = lambda cvss_exist, cvss_v3_exist: cvss_v3 if cvss_v3_exist else cvss if cvss_exist else "0.0"

    try:
        return float(get_score(cvss_exist, cvss_v3_exist))
    except Exception as e:
        print(e)
        return "0.0"



if __name__ == '__main__':
    assert get_cvss_score2("", "") == 0.0
    assert get_cvss_score2("0", "0") == 0.0
    assert get_cvss_score2("0.0", "0.0") == 0.0
    assert get_cvss_score2("   ", "0") == 0.0
    assert get_cvss_score2("0.0", "0") == 0.0
    assert get_cvss_score2("2.3", "1") == 1
    assert get_cvss_score2("1", "2.3") == 2.3
    assert get_cvss_score2("2.3", "2.3") == 2.3
    assert get_cvss_score2("2.3", "0") == 2.3
