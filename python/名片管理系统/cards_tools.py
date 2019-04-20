# 记录所有的名片字典
card_list = []


def show():
    print("*" * 50)
    print("欢迎使用【名片管理系统】")
    print("")
    print("1,新增名片")
    print("2,显示全部")
    print("3,搜索名片")
    print("")
    print("0,退出系统")
    print("*" * 50)


def new_card():
    name_str = input("请输入姓名:")
    phone_str = input("请输入电话:")
    qq_str = input("请输入qq:")
    email_str = input("请输入邮箱:")
    card_dice = {"name": name_str,
                 "phone": phone_str,
                 "qq": qq_str,
                 "email": email_str}
    card_list.append(card_dice)
    print("名片添加成功")


def show_all():
    """"显示所有名片"""
    if len(card_list) == 0:
        print("当前没有任何信息，请输入")
        return
    print("-" * 50)
    print("显示所有名片")
    # 打印表头
    for name in ["姓名", "电话", "QQ", "邮箱"]:
        print(name, end="\t\t")
    print("")
    print("=" * 50)
    for card_dict in card_list:
        print("%s\t\t%s\t\t%s\t\t%s\t\t" % (card_dict["name"], card_dict["phone"],
                                            card_dict["qq"], card_dict["email"]))


def deal_card(find_dict):
    """

    :param find_dict: 处理查找的字典
    """
    action_str = input("请输入要执行的操作 1修改 2 删除 0返回上级菜单")
    if action_str == "1":

        find_dict["name"] = input_card_info(find_dict["name"], "姓名:")
        find_dict["phone"] = input_card_info(find_dict["phone"], "电话:")
        find_dict["qq"] = input_card_info(find_dict["qq"], "qq:")
        find_dict["email"] = input_card_info(find_dict["email"], "email:")

    elif action_str == "2":

        card_list.remove(find_dict)
        print("删除成功")


def search_card():
    """
    查找记录
    """
    print("-" * 50)
    print("搜索名片")
    find_name = input("请输入要搜索的姓名：")
    for card_dict in card_list:
        if card_dict["name"] == find_name:
            print("找到了")
            for name in ["姓名", "电话", "QQ", "邮箱"]:
                print(name, end="\t\t")
            print("")
            print("=" * 50)
            print("%s\t\t%s\t\t%s\t\t%s\t\t" % (card_dict["name"], card_dict["phone"],
                                                card_dict["qq"], card_dict["email"]))
            deal_card(card_dict)
            break
    else:
        print("抱歉没有找到")


def input_card_info(dict_value, tip_message):
    """

    :param dict_value:字典中原有的值
    :param tip_message:输入的文字提示
    :return:
    """
    result_str = input(tip_message)
    if len(result_str) > 0:
        return result_str
    else:
        return dict_value
