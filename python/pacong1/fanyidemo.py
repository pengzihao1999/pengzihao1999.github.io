import requests
"""使用带参数的爬虫"""
# headers的构建
headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}
request_url = "https://fanyi.baidu.com/v2transapi"
data = {"from": "zh",
        "to": "en",
        "query": "嘻嘻哈哈",
        "transtype": "translang",
        "simple_means_flag": "3",
        "sign": "249607.470070",
        "token": "b01862bd6d087dbdb2dd562ecd940435"}
response =  requests.post(request_url,headers=headers,data=data)
print(response.status_code)
##拿到请求的url
print(response.request.url)
print(response.content.decode(encoding="utf-8"))