from sklearn.feature_extraction import DictVectorizer
from sklearn.feature_extraction.text import CountVectorizer
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.preprocessing import MinMaxScaler
from sklearn.preprocessing import StandardScaler
import jieba
import pandas as pd
from  sklearn.decomposition import PCA
def DicTrans():
    "字典特征抽取"
    Dictools = DictVectorizer()
    trDict = Dictools.fit_transform([{'city': '北京','temperature':100},
            {'city': '上海','temperature':60},
            {'city': '深圳','temperature':30}],)
    print(Dictools.feature_names_)
    print(trDict.toarray())

def WordsTrans():
    "对英文文本特征抽取"
    WordsTools = CountVectorizer()
    trWords = WordsTools.fit_transform(["life time python like","life like like like python python"]);
    print(WordsTools.get_feature_names())
    print(trWords.toarray())

def CHWordsTrans():
    "对中文文本特征抽取"
    c1 = jieba.cut("两人对酌山花开，一杯一杯复一杯")
    c2 = jieba.cut("我醉欲眠卿且去，明朝有意抱琴来")
    cc1 = list(c1)
    cc2 = list(c2)
    r1 = " ".join(cc1)
    r2 = " ".join(cc2)
    WordsTools = CountVectorizer()
    trWords = WordsTools.fit_transform([r1,r2])
    print(WordsTools.get_feature_names())
    print(trWords.toarray())

def TfIdf():
    "对中文文本进行TF IDF判断词的重要性"
    c1 = jieba.cut("两人对酌山花开，一杯一杯复一杯")
    c2 = jieba.cut("我醉欲眠卿且去，明朝有意抱琴来")
    cc1 = list(c1)
    cc2 = list(c2)
    print(cc1)
    print(cc2)
    r1 = " ".join(cc1)
    r2 = " ".join(cc2)
    print(r1)
    print(r2)
    TfIdfTools = TfidfVectorizer()
    data = TfIdfTools.fit_transform([r1,r2])
    print(TfIdfTools.get_feature_names())
    print(data.toarray())

def MMS():
    "数据的归一化 收异常点影响大"
    MMStools = MinMaxScaler()
    data = MMStools.fit_transform([[90,2,10,40],
                                    [60,4,15,45],
                                    [75,3,13,46]])
    print(data)

def SSS():
    "数据的标准化 受异常点影响不是很大"
    "是每一列的均值为0,标准差为1"
    SSStools =StandardScaler()
    data = SSStools.fit_transform([[90,2,10,40],
                                    [60,4,15,45],
                                    [75,3,13,46]])
    print(data)
def PCA():
    prior = pd.read_csv("D:\dataset\PCA instacart-market-basket\order_products__prior.csv")
    product = pd.read_csv("D:\dataset\PCA instacart-market-basket\products.csv")
    orders = pd.read_csv("D:\dataset\PCA instacart-market-basket\orders.csv")
    aisles = pd.read_csv("D:\dataset\PCA instacart-market-basket\\aisles.csv")
    data1 = pd.merge(prior,product,on=['product_id','product_id'])
    data2 = pd.merge(data1,orders,on=['order_id','order_id'])
    msg = pd.merge(data2,aisles,on=['aisle_id','aisle_id'])
    re = pd.crosstab(msg['user_id'],msg["aisle"])
    arr = PCA(n_components=0.9)



if __name__ == '__main__':
    DicTrans()

