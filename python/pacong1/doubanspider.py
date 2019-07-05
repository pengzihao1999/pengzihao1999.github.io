import requests
import json
class DouBan_Spider:
    def __init__(self):
        self.url = "https://movie.douban.com/j/new_search_subjects?start={}&countries=美国"
        self.header = {
            'User-Agent': "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}

    def send_get(self,url,num):
        #拿到url地址发送数据 拿到num数值表示是要获取数据的开始位置
        response = requests.get(self.url.format(num),headers = self.header)
        content_list  =  response.content.decode()#是json字符串 字典中有列表
        result = json.loads(content_list) #把json字符串类型转化为python中的数据类型
        print(result)
        return result

    def writer_to_file(self,content_list): #以追加的方式写入文件
        with open("douban.txt","a",encoding="utf-8") as f :
            for content in content_list["data"]:
                # print(content)
                f.write(json.dumps(content,ensure_ascii=False))
                f.write("\n")

    def run(self):
        """
        对豆瓣某个分类的前1000条记录进行爬取
        实现思路：
        1.拿到请求的url地址，设置header等，发送get请求拿到响应
        2.把响应的内容（字典）进行获取
        3.写入字典到文件中
        4.拿到下一个url地址
        5.发送请求，获得数据
        :return:
        """
        num = 0
        while num <= 100:
            print(num)
            content_list = self.send_get(self.url,num)
            self.writer_to_file(content_list)
            num = num + 20

if __name__ == '__main__':
    douban_spider  =  DouBan_Spider()
    douban_spider.run()
