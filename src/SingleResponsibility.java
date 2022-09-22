public class SingleResponsibility {

    /*
    S - Single-responsibility principle

    Single responsibility prensibi sınıflarımızın iyi tanımlanmış tek bir sorumluluğu olması gerektiğini anlatmaktadır.
    Bir sınıf (nesne) yalnızca bir amaç uğruna değiştirilebilir, o da o sınıfa yüklenen sorumluluktur,
    yani bir sınıfın(fonksiyona da indirgenebilir) yapması gereken yalnızca bir işi olması gerekir.

    Eğer geliştirdiğiniz sınıf ya da fonksiyon birden fazla amaca hizmet ediyorsa, bu kurala aykırı bir geliştirme sürecinde
    olduğunuz anlamına geliyor. Bunu farkettiğinizde amaçlara uygun olarak parçalamanız gerekmektedir.

    Gereksinimler değiştiğinde, yazılan kodda da değişmesi gereken kısımlar olacaktır. Bu da yazılan sınıfların(nesnelerin)
    bir kısmının ya da tamamının değiştirilmesi anlamına gelir. Bir sınıf ne kadar fazla sorumluluk alırsa, o kadar fazla
    değişime uğramak zorunda kalır. Böylece birçok kod parçasının değişmesine neden olurken, yeniden yazımda;
    değişikliklerin uygulanması da bir o kadar zorlaşır.

    Bir sınıfı veya fonksiyonu geliştirdiğimizde sorumluluğunu ya da amacını iyi belirleyip, sınıfı ona göre tasarlamamız gerekir,
    böylece oluşabilecek herhangi bir değişimden, olabildiğince az şeyi güncelleyerek ve düzelterek istenilen geliştirmeyi
    gerçekleştirmiş oluruz. Sorumluluğun azaltılması demek değişime daha kolay adapte olmak demektir.

    Test — Bir sorumluluğu olan bir sınıfta çok daha az sayıda test-case olacaktır.
    Daha az bağımlılık — Tek bir sınıfta daha tek bir sorumluluğunun olması daha az bağımlılık sağlayacaktır.
    Yalın ve anlaşılır yapılar — Daha az sorumluluk daha yalın veya küçük yapılar ulaşmasını sağlar.
    Daha küçük yapılar ise monolitik yapılara göre çok daha avantajlıdır ve kod anlaşılırlığını/okunurluğunu artırır.

    Kötü bir örnekle başlayalım.


   public class User {
        private Long id;
        private String name;
        private String street;
        private String city;
        private String username;

        //Getters, setters

        public void changeAddress(String street,String city) {
            //logic
        }

        public void login(String username) {
            //logic
        }

        public void logout(String username) {
        //logic
        }
    }


Burada Adres ile ilgili street ve city gibi veriler direkt olarak User sınıfı içerisinde bulunmalı mı gerçekten ?
Herhangi bir ek adres bilgisi istendiğinde(country yada zipCode gibi) burada tamamen User sınıfını etkileyecektir.
User sınıfı direkt olarak sorumlu olmadığı bir işlemden etkilenmiş olacak. “street”, “city” gibi veriler sadece
adres için gereklidir, bu durumda Address adında yeni bir class oluştursak daha iyi olur.


public class LoginService{
   public void login(String username) {
       //log-in logic
   }

   public void logout(String username) {
       //log-out logic
   }
}


Login ve logout gibi işlemler ne kadar User bilgisine ihtiyaç duysada User sınıfının sorumluluğunda değildir.
Bu fonksiyonları ayrı bir sınıfın sorumluluğuna bırakmalıyız. Böylece login işlemlerini User sınıfından arındırmış olacağız
ve LoginService’ini de single responsibility için düzenlemiş olduk.

Diyelim ki User sınıfından changeAddress kısmını düzenledik. Yine şöyle kötü bir örneğimiz var.


public class AddressService{
   public void changeAddress(User user) {
      //logic
   }
}


Bu sınıf ve fonksiyon içerisinde yapacağım her şey sadece Address’i ilgilendirmelidir. Dolayısıyla user bu metodun içinde
yer alamamalıdır. Çünkü fonksiyon sadece adres değişikliği ile ilgilenmektedir. Daha önce değindiğim yeni Address sınıfımız var
ve bundan yararlanalım, bu durumda doğru olanı yapmamız gerekiyor.


public class User {

   private Long id;
   private Address name;

   //Getter,setter
}
ve

public class Address {

   private String street;
   private String city;
   private String country;
   //Getter,setter
}

yeni oluşan durumda

public class AddressService{
  public void changeAddress(Address address) {
      // Sadece addressle ilgileniyorum ve ondan sorumluyum userdaki değişiklikler beni etkilemez.
       //logic
   }
}

Sorumlulukları her bir sınıfa etkili bir şekilde ayırdık ve böylece bir yerdeki kod değiştirme şansını ve
koddaki herhangi bir yerin diğerini bozma şansını azalttık. Güncelleştirmeler gerektiğinde kolayca entegre
edebileceğimiz bir yapı kurmuş olduk. Her bir sınıf ve fonksiyon için tek bir iş, gelecekteki sorunları önler,
anlaşılır kod yazmanızı sağlar ve yazılımınıza yeni özellikler eklemek için kolaylıklar sağlar.

KAYNAK:https://gokhana.medium.com/single-responsibility-prensibi-nedir-kod-%C3%B6rne%C4%9Fiyle-soli%CC%87d-c8b1602be602

*/

}
