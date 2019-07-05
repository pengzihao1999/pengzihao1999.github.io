import  requests

url_temp = "https://tieba.baidu.com/f?"

head = {"User-Agent":"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}

param = {"kw":"李毅","pn":"50"}

# response = requests.get(url_temp,header=head,params=param)
url = "https://www.baidu.com/s"
response = requests.get(url_temp,headers = head,params=param)
print(response.request.url)
print(response.content.decode())
print(response.status_code)
