import com.google.gson.Gson;
import kong.unirest.HttpResponse;
import kong.unirest.Unirest;
import org.junit.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntegrationTest {

    @BeforeClass
    public static void Setup(){
        String input = "[{\"id\":\"5e445b6c6ab90e0af6068d43\",\"name\":\"شمرون کباب (دشت بهشت)\",\"location\":{\"x\":-35,\"y\":42},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5a67230c4e090.jpeg\",\"menu\":[{\"name\":\"خوراک جوجه کباب بدون استخوان (ران)\",\"description\":\"خوراک جوجه کباب بدون استخوان (ران) تهیه شده از بهترین مواد اولیه\",\"price\":29000,\"popularity\":0.6,\"image\":\"https://static.snapp-food.com/200x201/cdn/23/60/8/vendor/5e237f13a452a.jpeg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d4c\",\"name\":\"تله پیتزا (سعادت آباد)\",\"location\":{\"x\":-98,\"y\":161},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5a26a27d8fbf0.jpg\",\"menu\":[{\"name\":\"ساندویچ رست بیف\",\"description\":\"ساندویچ رست بیف تهیه شده از بهترین مواد اولیه\",\"price\":12000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/19/92/7/vendor/5d9ce3a460917.jpg\"},{\"name\":\"ساندویچ استیک\",\"description\":\"ساندویچ استیک تهیه شده از بهترین مواد اولیه\",\"price\":19000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/19/92/7/vendor/5d9ce3b511f19.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068da2\",\"name\":\"دکتر کباب\",\"location\":{\"x\":-144,\"y\":-163},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d233faf5fe92.jpg\",\"menu\":[{\"name\":\"خوراک برگ گوسفندی دکتر\",\"description\":\"خوراک برگ گوسفندی دکتر تهیه شده از بهترین مواد اولیه\",\"price\":12000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/32/65/2/vendor/5da85a61d51c6.jpg\"},{\"name\":\"کباب کاردی دکتر ( سیخ اضافی )\",\"description\":\"کباب کاردی دکتر ( سیخ اضافی ) تهیه شده از بهترین مواد اولیه\",\"price\":33000,\"popularity\":0.5,\"image\":\"https://static.snapp-food.com/200x201/cdn/32/65/2/vendor/5dcc070f286bc.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068dbb\",\"name\":\"پیتزا و همبرگر بهروز\",\"location\":{\"x\":-173,\"y\":192},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5c62d3b258415.jpg\",\"menu\":[{\"name\":\"پیتزا مخصوص 24 سانتیمتری\",\"description\":\"پیتزا مخصوص 24 سانتیمتری تهیه شده از بهترین مواد اولیه\",\"price\":32000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/35/70/1/vendor/5cc17f4c8934e.jpg\"},{\"name\":\"پیتزا مخصوص 30 سانتیمتری\",\"description\":\"پیتزا مخصوص 30 سانتیمتری تهیه شده از بهترین مواد اولیه\",\"price\":23000,\"popularity\":0.6,\"image\":\"https://static.snapp-food.com/200x201/cdn/35/70/1/vendor/5cc1c26951f58.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d79\",\"name\":\"فست فود هشتگ\",\"location\":{\"x\":73,\"y\":231},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5df098cfedda0.JPG\",\"menu\":[{\"name\":\"پیتزا بیکن سه نفره\",\"description\":\"پیتزا بیکن سه نفره تهیه شده از بهترین مواد اولیه\",\"price\":13000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/48/49/2/vendor/5d9b969b6090a.jpg\"},{\"name\":\"پیتزا شیکاگو یک نفره\",\"description\":\"پیتزا شیکاگو یک نفره تهیه شده از بهترین مواد اولیه\",\"price\":31000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/48/49/2/vendor/5d9b97280525e.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d6a\",\"name\":\"رستوران ایتالیایی آمانو\",\"location\":{\"x\":-158,\"y\":141},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d3485e052688.jpg\",\"menu\":[{\"name\":\"پاستا چیکن آلفردو\",\"description\":\"پاستا چیکن آلفردو تهیه شده از بهترین مواد اولیه\",\"price\":12000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/45/49/2/vendor/5e1b204546469.jpeg\"},{\"name\":\"پاستا بیف آلفردو\",\"description\":\"پاستا بیف آلفردو تهیه شده از بهترین مواد اولیه\",\"price\":12000,\"popularity\":0.0,\"image\":\"https://static.snapp-food.com/200x201/cdn/45/49/2/vendor/5e1b1fd0631fa.jpeg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d4d\",\"name\":\"کوک (سعادت آباد)\",\"location\":{\"x\":27,\"y\":255},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5a63370008105.png\",\"menu\":[{\"name\":\"قهوه فرانسه (250 گرم)\",\"description\":\"قهوه فرانسه (250 گرم) تهیه شده از بهترین مواد اولیه\",\"price\":11000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/23/11/6/product_image/vendor/5db0070eea232.jpg\"},{\"name\":\"چای ماسالا\",\"description\":\"چای ماسالا تهیه شده از بهترین مواد اولیه\",\"price\":30000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/23/11/6/product_image/vendor/5db0075ebef0b.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d5d\",\"name\":\"باقلوا استانبولی باکلاواچی (سعادت آباد)\",\"location\":{\"x\":-238,\"y\":282},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5de3b2fdac36b.jpg\",\"menu\":[{\"name\":\"باقلوا گردویی (750 گرم)\",\"description\":\"باقلوا گردویی (750 گرم) تهیه شده از بهترین مواد اولیه\",\"price\":29000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/50/80/4/product_image/vendor/5dee27121d5a4.jpg\"},{\"name\":\"باقلوا گردویی (یک کیلو)\",\"description\":\"باقلوا گردویی (یک کیلو) تهیه شده از بهترین مواد اولیه\",\"price\":14000,\"popularity\":0.9,\"image\":\"https://static.snapp-food.com/200x201/cdn/50/80/4/product_image/vendor/5dee271c4e21e.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d6c\",\"name\":\"تهیه غذای مارتیک\",\"location\":{\"x\":-300,\"y\":-166},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5dcc0909128d2.jpg\",\"menu\":[{\"name\":\"چلو کباب کوبیده (یک سیخ)\",\"description\":\"چلو کباب کوبیده (یک سیخ) تهیه شده از بهترین مواد اولیه\",\"price\":25000,\"popularity\":0.0,\"image\":\"https://static.snapp-food.com/200x201/cdn/43/39/8/vendor/5dc6c047d1551.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d51\",\"name\":\"غذای خانگی ژیکال\",\"location\":{\"x\":-185,\"y\":24},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5b03f8cd10ae6.jpg\",\"menu\":[{\"name\":\"چلو کباب کوبیده مخصوص\",\"description\":\"چلو کباب کوبیده مخصوص تهیه شده از بهترین مواد اولیه\",\"price\":10000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/27/10/4/vendor/5b015b7768fc5.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068dae\",\"name\":\"کترینگ ملت ولیعصر\",\"location\":{\"x\":-180,\"y\":-291},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5ccafb99375e0.jpg\",\"menu\":[{\"name\":\"چلو کباب وزیری\",\"description\":\"چلو کباب وزیری تهیه شده از بهترین مواد اولیه\",\"price\":13000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/41/36/5/vendor/5d33669d9c7c3.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d4f\",\"name\":\"کترینگ شیمک\",\"location\":{\"x\":164,\"y\":-24},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5df0eb0a39a12.jpg\",\"menu\":[{\"name\":\"چلو کباب سلطانی\",\"description\":\"چلو کباب سلطانی تهیه شده از بهترین مواد اولیه\",\"price\":37000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/08/5/vendor/5db9cf4778c16.jpg\"},{\"name\":\"چلو کباب برگ معمولی\",\"description\":\"چلو کباب برگ معمولی تهیه شده از بهترین مواد اولیه\",\"price\":15000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/08/5/vendor/5db9cf7e3771d.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d3f\",\"name\":\"کترینگ و تشریفات اسنوژی\",\"location\":{\"x\":-59,\"y\":-159},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5dc7c179bef72.jpeg\",\"menu\":[{\"name\":\"چلو کباب کوبیده سنتی ( دو سیخ )\",\"description\":\"چلو کباب کوبیده سنتی ( دو سیخ ) تهیه شده از بهترین مواد اولیه\",\"price\":20000,\"popularity\":0.6,\"image\":\"https://static.snapp-food.com/200x201/cdn/42/71/5/vendor/5d88efe8b16ec.jpg\"},{\"name\":\"چلو کباب لقمه سنتی \",\"description\":\"چلو کباب لقمه سنتی  تهیه شده از بهترین مواد اولیه\",\"price\":15000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/42/71/5/vendor/5d88f002a37c1.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d3c\",\"name\":\"ترمه ترنج\",\"location\":{\"x\":128,\"y\":-192},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5b7819fd4c791.jpg\",\"menu\":[{\"name\":\"چلو کباب کوبیده نیم پرس\",\"description\":\"چلو کباب کوبیده نیم پرس تهیه شده از بهترین مواد اولیه\",\"price\":33000,\"popularity\":0.2,\"image\":\"https://static.snapp-food.com/200x201/cdn/14/43/2/vendor/5dc693d54616d.jpg\"},{\"name\":\"چلو جوجه کباب (سینه) یک و نیم پرس\",\"description\":\"چلو جوجه کباب (سینه) یک و نیم پرس تهیه شده از بهترین مواد اولیه\",\"price\":21000,\"popularity\":1.0,\"image\":\"https://static.snapp-food.com/200x201/cdn/14/43/2/vendor/5dc694727eaf8.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d53\",\"name\":\"کافه رستوران مس مس\",\"location\":{\"x\":213,\"y\":246},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5dac0376dcf22.jpg\",\"menu\":[{\"name\":\"صبحانه مس مس\",\"description\":\"صبحانه مس مس تهیه شده از بهترین مواد اولیه\",\"price\":16000,\"popularity\":0.1,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/16/0/vendor/5df8e93c4e062.jpg\"},{\"name\":\"صبحانه انگلیسی\",\"description\":\"صبحانه انگلیسی تهیه شده از بهترین مواد اولیه\",\"price\":34000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/16/0/vendor/5df8e9774e31b.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d49\",\"name\":\"رستوران ریحون\",\"location\":{\"x\":-81,\"y\":-8},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d15f42838d79.jpg\",\"menu\":[{\"name\":\"چلو کباب کوبیده لقمه\",\"description\":\"چلو کباب کوبیده لقمه تهیه شده از بهترین مواد اولیه\",\"price\":12000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/42/65/6/vendor/5d186336d5ed5.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d61\",\"name\":\"پامچال\",\"location\":{\"x\":-150,\"y\":-20},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5ce513d438cf9.jpg\",\"menu\":[{\"name\":\"پیتزا مخصوص\",\"description\":\"پیتزا مخصوص تهیه شده از بهترین مواد اولیه\",\"price\":32000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/32/04/2/product_image/vendor/5d95c38862a38.jpg\"},{\"name\":\"پیتزا رست بیف\",\"description\":\"پیتزا رست بیف تهیه شده از بهترین مواد اولیه\",\"price\":29000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/32/04/2/product_image/vendor/5d95c36f81585.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d52\",\"name\":\"مستر دیزی (سعادت آباد)\",\"location\":{\"x\":-273,\"y\":-36},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5cf61e3ebaecf.jpg\",\"menu\":[{\"name\":\"دیزی کلاسیک\",\"description\":\"دیزی کلاسیک تهیه شده از بهترین مواد اولیه\",\"price\":35000,\"popularity\":0.1,\"image\":\"https://static.snapp-food.com/200x201/cdn/41/63/9/product_image/vendor/5d47c226ba258.jpeg\"},{\"name\":\"دیزی اسپایسی\",\"description\":\"دیزی اسپایسی تهیه شده از بهترین مواد اولیه\",\"price\":13000,\"popularity\":0.6,\"image\":\"https://static.snapp-food.com/200x201/cdn/41/63/9/product_image/vendor/5d47c21ae9b48.jpeg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d4e\",\"name\":\"پرپل سوخاری (سعادت آباد)\",\"location\":{\"x\":242,\"y\":127},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5c7fd36e59080.jpg\",\"menu\":[{\"name\":\"سیب زمینی سرخ کرده\",\"description\":\"سیب زمینی سرخ کرده تهیه شده از بهترین مواد اولیه\",\"price\":26000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/30/27/1/vendor/5c72d2842aa06.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d83\",\"name\":\"کترینگ الف\",\"location\":{\"x\":64,\"y\":-106},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5c3df8159bc8d.jpg\",\"menu\":[{\"name\":\"چلو کباب لقمه مخصوص\",\"description\":\"چلو کباب لقمه مخصوص تهیه شده از بهترین مواد اولیه\",\"price\":23000,\"popularity\":0.1,\"image\":\"https://static.snapp-food.com/200x201/cdn/33/52/9/vendor/5c70552be423d.jpg\"},{\"name\":\"چلو جوجه کباب معمولی\",\"description\":\"چلو جوجه کباب معمولی تهیه شده از بهترین مواد اولیه\",\"price\":35000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/33/52/9/vendor/5c7054d535279.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068da8\",\"name\":\"پیتزا همبرگر بهروز (اصلی)\",\"location\":{\"x\":-29,\"y\":-16},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d42d2af17043.jpeg\",\"menu\":[{\"name\":\"پیتزا مخصوص\",\"description\":\"پیتزا مخصوص تهیه شده از بهترین مواد اولیه\",\"price\":23000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/45/22/5/vendor/5d5d0dcc907ad.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d64\",\"name\":\"شیرینی پاپا (ایران بانو)\",\"location\":{\"x\":53,\"y\":137},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5dbed8ccccd33.jpg\",\"menu\":[{\"name\":\"دسر پلمبیر لیوانی (یک عدد)\",\"description\":\"دسر پلمبیر لیوانی (یک عدد) تهیه شده از بهترین مواد اولیه\",\"price\":24000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/75/6/product_image/vendor/5dc7b15e5065c.jpg\"},{\"name\":\"شیرینی تر مخلوط یک کیلو (حدود 20 عدد)\",\"description\":\"شیرینی تر مخلوط یک کیلو (حدود 20 عدد) تهیه شده از بهترین مواد اولیه\",\"price\":28000,\"popularity\":0.0,\"image\":\"https://static.snapp-food.com/200x201/cdn/49/75/6/product_image/vendor/5dc7b19acf8a6.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068da5\",\"name\":\"کانتر برگر\",\"location\":{\"x\":-115,\"y\":22},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d5a384c6362b.jpeg\",\"menu\":[{\"name\":\"سیب زمینی سرخ کرده مخصوص\",\"description\":\"سیب زمینی سرخ کرده مخصوص تهیه شده از بهترین مواد اولیه\",\"price\":38000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/46/48/4/vendor/5df7946d9eae0.jpeg\"}]},{\"id\":\"5e445b6c6ab90e0af6068da3\",\"name\":\"پلو دیگی (شهرک فجر)\",\"location\":{\"x\":68,\"y\":138},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5851537e9f438.jpg\",\"menu\":[{\"name\":\"کشک بادمجان\",\"description\":\"کشک بادمجان تهیه شده از بهترین مواد اولیه\",\"price\":16000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/12/43/2/product_image/vendor/5db9568ca7456.jpg\"},{\"name\":\"میرزاقاسمی\",\"description\":\"میرزاقاسمی تهیه شده از بهترین مواد اولیه\",\"price\":34000,\"popularity\":0.5,\"image\":\"https://static.snapp-food.com/200x201/cdn/12/43/2/product_image/vendor/5db956a43749c.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d40\",\"name\":\"زیگ زاگ (سعادت آباد)\",\"location\":{\"x\":-40,\"y\":-39},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/588edaf94fdd0.jpg\",\"menu\":[{\"name\":\"پیتزا مارگاریتا (ایتالیایی) دو نفره (32 سانتی\u200Cمتری)\",\"description\":\"پیتزا مارگاریتا (ایتالیایی) دو نفره (32 سانتی\u200Cمتری) تهیه شده از بهترین مواد اولیه\",\"price\":39000,\"popularity\":1.0,\"image\":\"https://static.snapp-food.com/200x201/cdn/13/06/8/vendor/5b39ea6912cce.jpg\"},{\"name\":\"پیتزا چیکن لاورز (ایتالیایی) دو نفره (32 سانتی\u200Cمتری)\",\"description\":\"پیتزا چیکن لاورز (ایتالیایی) دو نفره (32 سانتی\u200Cمتری) تهیه شده از بهترین مواد اولیه\",\"price\":23000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/13/06/8/vendor/5b39e9f57fb1b.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d84\",\"name\":\"کافه رستوران ایتالیایی ریچی (اسپرلوس سابق)\",\"location\":{\"x\":-6,\"y\":-41},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5dea040a2d520.jpg\",\"menu\":[{\"name\":\"بشقاب مخصوص ریچی\",\"description\":\"بشقاب مخصوص ریچی تهیه شده از بهترین مواد اولیه\",\"price\":39000,\"popularity\":0.8,\"image\":\"https://static.snapp-food.com/200x201/cdn/17/54/1/vendor/5b5054fcb62d5.jpg\"},{\"name\":\"تی بن\",\"description\":\"تی بن تهیه شده از بهترین مواد اولیه\",\"price\":27000,\"popularity\":0.4,\"image\":\"https://static.snapp-food.com/200x201/cdn/17/54/1/vendor/5b50553171cc0.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068db9\",\"name\":\"خانه بال\",\"location\":{\"x\":271,\"y\":-67},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5da311b4cb2b9.jpeg\",\"menu\":[{\"name\":\"برگر باربیکیو\",\"description\":\"برگر باربیکیو تهیه شده از بهترین مواد اولیه\",\"price\":24000,\"popularity\":0.9,\"image\":\"https://static.snapp-food.com/200x201/cdn/48/55/3/product_image/vendor/5da421c511c53.jpg\"},{\"name\":\"برگر مارگاریتا\",\"description\":\"برگر مارگاریتا تهیه شده از بهترین مواد اولیه\",\"price\":40000,\"popularity\":0.9,\"image\":\"https://static.snapp-food.com/200x201/cdn/48/55/3/product_image/vendor/5da421e583ad7.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d3b\",\"name\":\"رستوران طریقت نو (سعادت آباد)\",\"location\":{\"x\":214,\"y\":-199},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d934e5b3dcc8.jpg\",\"menu\":[{\"name\":\"چلو جوجه کباب 250 گرم (سینه)\",\"description\":\"چلو جوجه کباب 250 گرم (سینه) تهیه شده از بهترین مواد اولیه\",\"price\":17000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/45/89/5/product_image/vendor/5dac67942a4a2.jpg\"},{\"name\":\"چلو جوجه کباب 300 گرم (ران)\",\"description\":\"چلو جوجه کباب 300 گرم (ران) تهیه شده از بهترین مواد اولیه\",\"price\":29000,\"popularity\":0.9,\"image\":\"https://static.snapp-food.com/200x201/cdn/45/89/5/product_image/vendor/5da85ac593b34.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d88\",\"name\":\"سوپ بی بی (شیخ بهایی)\",\"location\":{\"x\":-218,\"y\":-25},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5d667a9e8ffc2.jpeg\",\"menu\":[{\"name\":\"سوپ دال عدس (پرسی)\",\"description\":\"سوپ دال عدس (پرسی) تهیه شده از بهترین مواد اولیه\",\"price\":19000,\"popularity\":0.3,\"image\":\"https://static.snapp-food.com/200x201/cdn/41/27/6/product_image/vendor/5df1df96272d4.jpg\"},{\"name\":\"سوپ دال عدس (یک کیلو)\",\"description\":\"سوپ دال عدس (یک کیلو) تهیه شده از بهترین مواد اولیه\",\"price\":23000,\"popularity\":0.1,\"image\":\"https://static.snapp-food.com/200x201/cdn/41/27/6/product_image/vendor/5df1df966b3b1.jpg\"}]},{\"id\":\"5e445b6c6ab90e0af6068d9f\",\"name\":\"خانه کباب\",\"location\":{\"x\":243,\"y\":241},\"logo\":\"https://static.snapp-food.com/media/cache/vendor_logo/uploads/images/vendors/logos/5c78f0a5c056b.jpeg\",\"menu\":[{\"name\":\"چلو کباب میکس خانه کباب \",\"description\":\"چلو کباب میکس خانه کباب  تهیه شده از بهترین مواد اولیه\",\"price\":11000,\"popularity\":0.7,\"image\":\"https://static.snapp-food.com/200x201/cdn/36/69/0/vendor/5c8240700a96c.jpg\"}]}]";
        Loghme loghme = new Loghme();
        Server server = new Server();
        Gson gson = new Gson();
        Restaurant[] Restaurants = gson.fromJson(input, Restaurant[].class);
        for (Restaurant restaurant: Restaurants){
            loghme.addRestaurant(restaurant);
        }
        Server.createServer(loghme);
    }
    @Test
    public void GetRestaurant(){
        HttpResponse response1 = Unirest.get("http://localhost:8080/getRestaurant/5e445b6c6ab90e0af6068d43").asString();
        assertEquals(response1.getStatus() , 200);
        HttpResponse response2 = Unirest.get("http://localhost:8080/getRestaurant/5e445b6c6ab90e0af6068da2").asString();
        assertEquals(response2.getStatus() , 403);
        HttpResponse response3 = Unirest.get("http://localhost:8080/getRestaurant/5eeeeeeeeeeeeeeeeeeeeeee").asString();
        assertEquals(response3.getStatus() , 404);
    }
}
