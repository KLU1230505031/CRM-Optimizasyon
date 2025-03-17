import java.util.*;

class Musteri {
    String ad;
    String sehir;
    String talep;

    public Musteri(String ad, String sehir, String talep) {
        this.ad = ad;
        this.sehir = sehir;
        this.talep = talep;
    }
}

class Temsilci {
    String ad;
    List<String> hizmetVerdigiSehirler;
    boolean uygun;

    public Temsilci(String ad, List<String> sehirler) {
        this.ad = ad;
        this.hizmetVerdigiSehirler = sehirler;
        this.uygun = true;
    }
}

class Kampanya {
    String ad;
    int maliyet;
    int getiri;

    public Kampanya(String ad, int maliyet, int getiri) {
        this.ad = ad;
        this.maliyet = maliyet;
        this.getiri = getiri;
    }
}

public class Main {

    public static Map<Musteri, Temsilci> temsilciAtama(List<Musteri> musteriler, List<Temsilci> temsilciler) {
        Map<Musteri, Temsilci> eslesme = new HashMap<>();

        for (Musteri musteri : musteriler) {
            for (Temsilci temsilci : temsilciler) {
                if (temsilci.uygun && temsilci.hizmetVerdigiSehirler.contains(musteri.sehir)) {
                    eslesme.put(musteri, temsilci);
                    temsilci.uygun = false; // Bir müşteri atanırsa uygunluk durumu güncellenir
                    break;
                }
            }
        }

        return eslesme;
    }

    public static List<Kampanya> kampanyaSecimi(List<Kampanya> kampanyalar, int butce) {
        int n = kampanyalar.size();
        int[][] dp = new int[n + 1][butce + 1];

        for (int i = 1; i <= n; i++) {
            Kampanya k = kampanyalar.get(i - 1);
            for (int b = 0; b <= butce; b++) {
                if (k.maliyet <= b) {
                    dp[i][b] = Math.max(dp[i - 1][b], dp[i - 1][b - k.maliyet] + k.getiri);
                } else {
                    dp[i][b] = dp[i - 1][b];
                }
            }
        }

        List<Kampanya> secilenler = new ArrayList<>();
        int b = butce;
        for (int i = n; i > 0 && b > 0; i--) {
            if (dp[i][b] != dp[i - 1][b]) {
                Kampanya k = kampanyalar.get(i - 1);
                secilenler.add(k);
                b -= k.maliyet;
            }
        }

        return secilenler;
    }

    public static void main(String[] args) {
        List<Musteri> musteriler = Arrays.asList(
                new Musteri("Musteri1", "İstanbul", "Teknik Destek"),
                new Musteri("Musteri2", "Ankara", "Ürün Bilgisi")
        );

        List<Temsilci> temsilciler = Arrays.asList(
                new Temsilci("Temsilci1", Arrays.asList("İstanbul", "İzmir")),
                new Temsilci("Temsilci2", Arrays.asList("Ankara", "Bursa"))
        );

        List<Kampanya> kampanyalar = Arrays.asList(
                new Kampanya("İndirim", 1000, 3000),
                new Kampanya("Sadakat Programı", 500, 1500),
                new Kampanya("Yeni Ürün Tanıtımı", 2000, 4000)
        );

        int butce = 2500;

        Map<Musteri, Temsilci> eslesme = temsilciAtama(musteriler, temsilciler);
        System.out.println("Müşteri - Temsilci Eşleşmeleri:");
        for (Map.Entry<Musteri, Temsilci> entry : eslesme.entrySet()) {
            System.out.println(entry.getKey().ad + " --> " + entry.getValue().ad);
        }

        List<Kampanya> secilenler = kampanyaSecimi(kampanyalar, butce);
        System.out.println("Seçilen Kampanyalar:");
        for (Kampanya k : secilenler) {
            System.out.println(k.ad + " (Getiri: " + k.getiri + ")");
        }
    }
}

