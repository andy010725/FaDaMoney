# 光頭發大財
## 簡介
你頭髮掉光，變成了一個光頭，身處台北街頭。

突然之間你什麼也想不起來，只記得上次有工作已經是6年前.....

你覺得這樣不行，一定要重返社會，不再荒廢。

這樣的你開始在街頭宣傳你的理念

.

『發大財』你這樣說道

.


世界於此動盪，發生天翻地覆的變化。

而你，光頭，能拯救一切.....

.

## 玩法

首先可以看到這是我們的基礎介面，可以看到右上角的職業等級，這些將在你後續遊戲中可以提升等級以及職業。
如何獲得聲望以及經驗值呢，發大財就對了，當然你也可以採取掛機戰術讓他慢慢跳聲望。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/1.gif)

當達到某些條件後會遇到突發事件面臨困難的二擇一，這可是會嚴重影響聲望的選擇哦。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/2.png)

當然也有屬於主角的小語錄小故事可以看，可以慢慢提升職業與等級來解鎖觀看。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/3.png)
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/4.gif)

提升等級後你便可以獲得技能點數來強化你的各種技能來提升你的聲望。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/5.png)

在提高聲望方面，請別人來幫忙站台這是一定要的啦。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/6.gif)

還有許多小道具可以購買哦(有些可能是你新職位需要的道具)
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/7.gif)


看看競選高雄市長需要什麼東西吧，齊全後便可競選來獲得新職位。
![image](https://github.com/andy010725/FaDaMoney/blob/master/readpic/8.gif)



------------------------------------------------------------------------------------------------------------------------
## 使用到的技巧

### Thread
首先是動圖，我們是先繪製兩張圖片，然後使用執行緒的方式讓他切換圖片達到像是動圖的效果，這方面的秒數限制可以給玩家獎勵，讓秒數減少來提升聲望與經驗值進帳的效率。

### SharedPreferences
儲存遊戲變數也是重要的一環，不然讓他因為重新啟動便歸零之前的數據，所以我們使用SharedPreferences來存放變數以便之後的讀取。

### Fragment
在一個AvtivityView內可以放置一個可切換的View，同時不停止MainActivity運作，來達到放置更多遊戲訊息的方法，我們使用了一個主要的Fragment和其他6個子Fragment。

### Alert
當觸發某些行為時可以有提示給玩家，以免遺漏資訊。

### ProgressBar
設定每一個等級的上下限來給玩家更清楚的知道自己目前還差多少經驗便可升等。

### 圖片繪製
使用了小畫家繪圖以及小畫家3D來去背達到background以及前面人物的放置。




## 2019.6 NYA_PASS版權所有
