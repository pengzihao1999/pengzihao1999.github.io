import requests
import re
class xsbk_spider:
    def __init__(self):
        self.header = {
            'User-Agent': "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}
        self.url_temp = "https://www.qiushibaike.com/text/page/{}/"
    def send_get(self,url):
        print(url)
        response = requests.get(url,headers = self.header)
        return response.content.decode()

    def findcontent(self,content):
        # print(content)
        result = re.findall(r"<div class=\"content\">.*?<span>(.*?)</span>",content,re.S)
        return result

    def write_to_file(self,result_list):
        with open("xiushibaike.txt","a",encoding="utf-8") as f:
            for result in  result_list:

                f.write(result)
        f.close()
    def run(self):

        """
        实现逻辑
        1.拿到url地址，发送请求，获取数据
        2.通过正则表达式获取合适的数据，并保存数据到本地
        3.拿到下一个url地址
        """
        num  = 1
        while num <=13:

           content = self.send_get(self.url_temp.format(num))
            #正则来提取内容
           result_list  = self.findcontent(content)
           self.write_to_file(result_list)
           num = num+1

if __name__ == '__main__':
     xs = xsbk_spider()
     xs.run()