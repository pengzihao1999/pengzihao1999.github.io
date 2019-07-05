from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.naive_bayes import MultinomialNB
from sklearn.model_selection import train_test_split
from sklearn.datasets import fetch_20newsgroups

def byse():
    news = fetch_20newsgroups(subset="all")
    x_train, x_test, y_train, y_test = train_test_split(news.data,news.target,test_size=0.25)

    tfidftools = TfidfVectorizer()

    x_train = tfidftools.fit_transform(x_train)
    x_test = tfidftools.transform(x_test)
    print(x_train.toarray())

    Byse = MultinomialNB(alpha=1.0)
    Byse.fit(x_train,y_train)
    Byse.predict(x_test)
    print(Byse.score(x_test,y_test))


if __name__ == '__main__':
    byse()

