public class LiskovSubstitution {

   /* L- Liskov Substitution

    Kodlarımızda herhangi bir değişiklik yapmaya gerek duymadan alt sınıfları, türedikleri(üst) sınıfların yerine kullanabilmeliyiz.
    Alt seviye sınıflardan oluşan nesnelerin/sınıfların, ana(üst) sınıfın nesneleri ile yer değiştirdikleri zaman, aynı davranışı
    sergilemesi gerekmektedir. Türetilen sınıflar, türeyen sınıfların tüm özelliklerini kullanabilmelidir.

    Varolan ve LSP’ye uymayan Kare ve dikdörtgen örneğiyle başlayalım.

    LSP’ye uymayan yapı örneği;


    public class Square extends Rectangle {
    @Override
    public void setWidth(int width) {
        super.setWidth(width);
        super.setHeight(width);
    }
    @Override
    public void setHeight(int height) {
        super.setHeight(height);
        super.setWidth(height);
        }
    }

    Matematiksel olarak bir kareyi de bir dikdörtgen olarak kabul edebiliriz. Ama yazılım dünyasında da böyle kabul etmeli miydik ?

    @Test
    public void testRectangleArea() throws Exception {
    Rectangle rectangle = new Square();
    rectangle.setWidth(20);
    rectangle.setHeight(4);
    assertEquals(80, rectangle.area());
        }

    Kareyi de beklendiği yerde dikdörtgen olarak kullanılabilir hale getirmiş olduk. Ancak böyle yaparak dikdörtgen davranışındaki
    beklentiyi bozuyoruz. Çünkü karenin sadece tek bir kenar bilgisi yeterlidir yada uzunluk ve en bilgisi aynı olmak durumundadır.

    Matematiksel olarak karenin dikdörtgenden türediğini varsayabiliriz. Ama davranışsal olarak Kare Dikdörtgenin yerine geçmez,
    bu hiyerarşi Liskov prensibini (LSP) ihlal eder.

    O halde kareyi ve dikdörtgen’i LSP’ye prensibe uygun hale getirelim. Bu prensip, Open/Closed prensibine benzer ve open/closed
    prensibine uymak liskov prensibinin uygulanmasını kolaylaştırmaktadır.

    Bir karenin yüksekliğinin / genişliğinin değiştirilmesi, bir dikdörtgenin yüksekliğinin / genişliğinin değiştirilmesinden daha
    farklı davranır. Her ikiside birer şekli temsil eder. Buradan yola çıkarak şekil interface’ini oluşturalım.

    public interface Shape {
    long area();
    }

    Kare bir şekildir o halde Square adlı bir sınıf yaratarak Shape’den implement edebiliriz.


    public class Square implements Shape {
    private int size;
    public Square(int size) {
        this.size = size;
    }
    @Override
    public long area() {
        return size * size;
    }
    public void setSize(int size) {
        this.size = size;
        }
    }

    Dikdörtgen Kare ile farklı davranışlar gösterebiliyor o halde onu ayrı bir şekil olarak Rectangle adlı bir sınıf yaratıp
    Shape’den implement edebiliriz.


    public class Rectangle implements Shape {
    private int width;
    private int height;
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    @Override
    public long area() {
        return width * height;
    }
    public void setWidth(int width) {
        this.width = width;
    }
    public void setHeight(int height) {
        this.height = height;
        }
    }

    Artık Kare ve Dikdörtgen kendi davranışlarına sahip oldu. Ve her biri ayrı şekil olarak kabul ediliyor.
    Böylece alan hesaplama her bir şekile özgü matematiksel bir işlem içerebiliyor. Hadi test edelim.


    @Test
    public void testRectangleArea() throws Exception {
        Shape rectangle = new Rectangle(10, 5);
        assertEquals(50, rectangle.area());
    }
    @Test
    public void testSquareArea() throws Exception {
        Shape square = new Square(5);
        assertEquals(25, square.area());
    }

    LSP’ye uygunluk tam olarak sınıflardan beklenen davranışları karşılayabilecek bir hiyerarşi düzeni oluşturarak sınıf
    yapılarımızı geliştirmektir.

    KAYNAK:https://gokhana.medium.com/liskov-substitution-prensibi-nedir-kod-%C3%B6rne%C4%9Fiyle-soli%CC%87d-3cfc1cd63c1a


*/

}
