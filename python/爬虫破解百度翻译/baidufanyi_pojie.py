import requests
import execjs
import json
import pprint
import sys
class bdfanyi:
    def __init__(self,trans_str):
        self.delete_url = "https://fanyi.baidu.com/langdetect"
        self.trans_url = "https://fanyi.baidu.com/v2transapi"
        self.trans_str = trans_str
        self.header = {
            'User-Agent': "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/74.0.3729.169 Safari/537.36"}

    def send_depost(self):
        de_data = {"query": self.trans_str}
        response  = requests.post(self.delete_url,de_data,headers = self.header)
        # print(response.content.decode())
        # print(type(response.content.decode()))
        re = json.loads(response.content.decode(),encoding="utf-8")
        return re["lan"]

    def send_fanyipopst(self):
        fanyi_data = {"from": "zh" if self.send_depost()=="zh" else "en",
                        "to": "en" if self.send_depost()=="zh" else "zh",
                        "query": self.trans_str,
                        "transtype": "translang",
                        "simple_means_flag": "3",
                        "sign": self.sign(self.trans_str),
                        "token": "b01862bd6d087dbdb2dd562ecd940435" }
        Cookies = {
            "BAIDUID":"E5BB6C7348B207E45C3486FEEF987D2B:FG=1" ,
            "BIDUPSID":"E5BB6C7348B207E45C3486FEEF987D2B" ,
            "PSTM=1550637262":"MCITY=-50%3A276%3A315%3A78%3A46%3A" ,
            "REALTIME_TRANS_SWITCH=1": "FANYI_WORD_SWITCH=1; HISTORY_SWITCH=1",
            "SOUND_SPD_SWITCH=1":"SOUND_PREFER_SWITCH=1",
            "_cfduid":"d626a3b24ca7e86a65862420b8b23e2281557130322" ,
            "BDORZ":"B490B5EBF6F3CD402E515D22BCDA1598" ,
            "Hm_lvt_64ecd82404c51e03dc91cb9e8c025574":"1562247416,1562248667,1562251219,1562287161",
            "Hm_lpvt_64ecd82404c51e03dc91cb9e8c025574":"1562287161",
            "yjs_js_security_passport":"c871d63ce773ff4ae1c58367d3b75c8ee59b8d77_1562287161_js",
        }
        # print(fanyi_data)
        response = requests.post(self.trans_url,fanyi_data,headers = self.header,cookies =Cookies)
        # print(response.request.url)
        # print(response.status_code)
        # print(type(response))
        # print(response.content.decode())
        data_dict =  json.loads(response.content.decode())
        return data_dict["trans_result"]["data"][0]["dst"]
    def sign(self,trans_str):
        with open("baidufanyi.js",encoding="utf-8") as f:
            js = f.read()
        js_compile = execjs.compile(js)
        res = js_compile.call("e",trans_str)
        return res
    def run(self):
        """
        1.输入要翻译的内容
        2.根据翻译的内容发送post请求到百度，查询内容是英语还是中文等
        3.拿到查询结果
        4.构造好post请求表单数据，并通过执行js文件获得signed属性的值
        5.发送请求，得到响应
        6.如果返回来的格式是json，获取json中的翻译信息
        :return:
        """

        content = self.send_fanyipopst()
        print(content)

if __name__ == '__main__':
    while True:
        fanyi = bdfanyi(input("请输入你要翻译的内容"))
        fanyi.run()

