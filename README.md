CRM SİSTEMİ

Bu proje, müşteri destek temsilcisi atama ve bütçe bazlı pazarlama kampanyası seçimi yapan bir Java tabanlı CRM sistemidir.

ÖZELLİKLER

Müşteri Destek Temsilcisi Atama: Müşterilerin taleplerine ve bulundukları şehre göre uygun temsilci atanır.

Pazarlama Kampanyası Seçimi: Belirlenen bütçe dahilinde en yüksek getiriyi sağlayan kampanyalar seçilir.

NASIL ÇALIŞIR?

1. MÜŞTERİ VE TEMSİLCİ EŞLEŞTİRME

Bu işlemde, her müşteri için uygun bir temsilci atanır. Algoritmanın çalışma mantığı şöyledir:

Her müşteri için sırayla tüm temsilciler kontrol edilir.

Eğer temsilci, müşterinin bulunduğu şehre hizmet veriyorsa ve uygun durumdaysa, o müşteri bu temsilciye atanır.

Bir müşteri bir temsilciye atandığında, o temsilcinin uygunluk durumu false yapılır ve başka bir müşteriye atanamaz.

Bu yaklaşım Greedy (Açgözlü) Algoritma mantığına dayanır. Her müşteri için mümkün olan ilk uygun temsilci seçilir.

2. PAZARLAMA KAMPANYASI SEÇİMİ

Bu işlemde, verilen bütçe dahilinde maksimum getiriyi sağlayacak kampanyalar seçilir. Kullanılan yöntem:

0/1 Knapsack (Sırt Çantası) Problemi

Kampanyalar, ağırlık olarak maliyet ve değer olarak getiri şeklinde modellenir.

Dinamik programlama (DP) yöntemiyle çözülür.

dp[i][b] matrisi kullanılarak her kampanya için maliyet ve bütçe karşılaştırması yapılır.

En yüksek getiriyi sağlayan kampanyalar seçilerek listeye eklenir.

Bu algoritma, optimal kampanya kombinasyonunu bulmak için zaman karmaşıklığı O(n * b) olan bir yaklaşıma sahiptir.
