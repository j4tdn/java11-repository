A. class 
customer: id, name, phone, address 
Item:id, os, color, cost 
itemDetail: item,  quantity 
=> Order: customer, item_details[], datetime

B1; create a list of customers 
b2: create a array of items in store 
b3: shopping function
+ Who is buying 
+ List of items 
+ Amount of each item 
+ datetime


=======================
B. Object 
c1: KH1, Adam, 123, Newyork
c2: KH2, Kate, 234, Cali

i1: SS10+, Android, Black, 620
i2: SS20U, Android, Green, 840
i3: ip4+, iOS, white, 280
i3: ip12, iOS, Black, 880
i5: WP8, windowphone, Blue, 560

Order1: c1, {id1(i1, 3), id2(i4, 1) , id3(i2, 1)}, 10:10:10 08.05.2021
Order2: c2, {id1(i3, 2), id2(i5, 1) , id3(i2, 1)}, 20:10:12 07.05.2021
Order2: c2, {id1(i4, 1)}, 09:28:32 08.05.2021
   
C. Function 
 + Function: export (order) +> Total of amount: Void 
 