import requests
class tiebaspider:
    def __init__(self,tieba_name):##初始化方法用来初始公用变量
        self.tieba_name = tieba_name
        self.url_temp = "https://tieba.baidu.com/f?kw="+tieba_name+"&pn={}"
        self.header = {
            'User-Agent': "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}
    def get_urllists(self):##获取前一千页的url列表
        return [self.url_temp.format(i*50) for i in range(1000)]
    def send_request(self,url):##对url发送请求
        response = requests.get(self.url_temp,headers = self.header)
        return response.content.decode()


    def save_html(self,html,pagenumber):
        file_path = "{}贴吧第{}页.html".format(self.tieba_name,pagenumber)
        with open(file_path,'w',encoding="utf-8")as f:
            f.write(html)

    def run(self):
        """
        1.先获取所有url地址列表
        2.遍历所有url地址发送请求
        3.保存到文件中
        :return:
        """
        url_list = self.get_urllists()
        for url in url_list:
           filehtml =  self.send_request(url)
           self.save_html(filehtml,url_list.index(url)+1)

if __name__ == '__main__':
   tiebaspiders =  tiebaspider("嘻嘻哈哈")
   tiebaspiders.run()