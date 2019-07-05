import requests
"""使用带参数的爬虫"""
# headers的构建
headers = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}
request_url = "https://www.baidu.com/s"
params = {"wd":"帅哥"}
response =  requests.get(request_url,headers=headers,params=params)
print(response.status_code)
##拿到请求的url
print(response.request.url)