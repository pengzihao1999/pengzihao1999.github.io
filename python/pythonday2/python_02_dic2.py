xiaoming_dict = {"name": "小明",
                 "age": 18,
                 "gender": True,
                 "height": 175,
                 "weight": 72.5
                 }
# 迭代遍历字典
# 变量k是每一次循环中，获取到的键值对的Key
for k in  xiaoming_dict:
    print("%s - %s" % (k, xiaoming_dict[k]))

#  在开发中经常把多个字典放在一个列表中 再进行遍历
card_list = [
    {"name": "张三",
     "qq": "12455",
     "phone": "110"},
    {"name": "张Si",
     "qq": "124421",
     "phone": "114"}


]
for card_info in card_list:
    print(card_info)
    