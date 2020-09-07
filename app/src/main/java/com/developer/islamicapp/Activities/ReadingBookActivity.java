package com.developer.islamicapp.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.developer.islamicapp.R;
import com.developer.islamicapp.utils.Typcast;
import com.developer.islamicapp.utils.Typcastregular;

public class ReadingBookActivity extends AppCompatActivity {
String bookchk;
TextView book_data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        Typcastregular.Typcastregular(getApplicationContext(), "SERIF", "Jameel_Noori_Nastaleeq_Kasheeda.ttf");

        setContentView(R.layout.activity_reading_book);
        book_data=findViewById(R.id.book_text);

        book_data.setTypeface(new Typcast().Typcast(this,"A"));



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        try {
            bookchk=getIntent().getStringExtra("book");
        }catch (Exception e)
        {

        }
        switch (bookchk)
        {
            case "book1A":
                book_data.setText(
                  "قل آمنوا بہ او لا تؤمنوا ان الذین اوتوا العلم من قبلہ اذا یتلی علیھم یخرون علیہم للاذقان سجدا ( کہہ دیجۓ ! تم اس پر ایمان لاؤیا نہ لاؤ جنہیں اس سے پہلے علم دیا گیا ہے ان کے پاس تو جب بھی اس کی تلاوت کی جاتی ہے تو وہ ٹھوڑیوں کےبل سحدہ میں گرپڑتے ہیں ) \u200E \u200E ،"
                );
                break;

            case  "book1B":     book_data.setText(



                    "ان الذین عند ربھم لایستکبرون عن عبادتہ ویسبحونہ ولہ یسجدون ( یقینا جو آپ کے رب کے نزدیک ہیں وہ اس کی عبادت سے تکبر نہیں کرتے اور اس کی پاکی بیان کرتے ہیں اور اس کوسجدہ کرتے ہیں )"
            );

                break;

            case "book1C":      book_data.setText("اذا قرئ\u200F علیھم القرآن لایسجدون ( اور جب ان پر قرآن پڑھا جات ہے تو وہ سجدہ نہیں کرتے ) "
            );

                break;
            ///

            case  "book1D":    book_data.setText("الم تران اللہ یسجد لہ من فی السموات ومن فی الارض والشمس والقمر والنجوم والجبال والشجر والدواب وکثیر من الناس وکثیر حق علیہ العذاب ومن یھن اللہ فما لہ من مکرم ان اللہ یفعل مایشاء ( کیا تو دیکھ نہیں رہا کہ سب آسمان والے اور زمین والے ، اور سورج چاند اور ستارے اور پہاڑ اور درخت اور جانوراوربہت سے انسان بھی اللہ کے سامنے سجدہ کرتے ہیں ہاں بہت سے وہ بھی ہیں جن پر عذاب کا مقولہ ثابت ہوچکا ہے ، جسے اللہ تعالی ذلیل کرے اسے کوئ بھی عزت دینے والا نہیں ، یقینا اللہ تعالی جو چاہتا کرتا ہے )"
            );

                break;

            case  "book1E":      book_data.setText("وللہ یسجد من فی السماوات والارض طوعاوکرھا وظلالھم بالغدو والآصال اللہ ہی کے لیے زمین اور آسمان کی سب مخلوق خوشی اور ناخوشی سے سجدہ کرتی ہے ، اورصبح وشام ان کے ساۓ بھی ۔\u200F\u200E "

            );

            break;

            case "book1F":      book_data.setText(
                   "انما یومن بآیاتنا الذین اذا ذکروا بھا خروا سجدا وسبحوا بحمد ربھم وھم لایستکبرون ( ہماری آیتوں پر وہی ایمان لاتے ہیں جنہیں جب کبھی اس کی نصیحت کی جاتی ہے تو وہ سجدے میں گر پڑتے ہیں اور اپنے رب کی حمد کے ساتھ اس کی تسبیح پڑھتے ہیں اور تکبر نہیں کرتے )"
            );

                break;

                case "book1G":       book_data.setText(
                "کلا لا تطعہ واسجد واقترب خبردار ! اس کا کہنا ہرگز نہ ماننا اور سجدہ کراور قریب ہوجا )"
                );

                break;

            case  "book1H":      book_data.setText("واذا قیل لھم اسجدوا للرحمن قالوا وما الرحمن انسجد لما تامرنا وزادھم نفورا ( اور جب بھی ان سے رحمن کوسجدہ کرنے کا کہا جاتا ہے تو جواب دیتے ہیں رحمن کیا ہے ؟ کیا ہم اسے سجدہ کریں جس کا تو ہمیں حکم دے رہا ہے اور اس ( تبلیغ )نے ان کی نفرت میں مزید اضافہ کردیا )"

            );

                break;

            case  "book1I":       book_data.setText("فاسجدوا للہ واعبدوا ( تو اللہ ہی کو سجدہ کرو اور اس کی ہی عبادت کرو )"
            );

                break;

            case  "book1J":     book_data.setText("وللہ یسجد ما فی السماوات ومافی الارض من دابۃ والملائکۃ وھم لایستکبرون ( یقینا آسمان وزمین کے کل جاندار اور تمام فرشتے اللہ تعالی کے سامنے سجدہ کرتے ہیں اور ذرا بھی تکبر نہیں کرتے )"
            );

                break;


            case "book1k":      book_data.setText("\n" +
                    "الا یسجدوا للہ الذی یخرج الخبء فی السموات والارض ویعلم ما تخفون وما تعلنون ( کہ اسی اللہ تعالی کے لیے سجدے کریں جو آسمانوں اور زمینوں کی پوشیدہ چیزوں کو نکالتا ہے ، اور جو کچھ تم چھپاتے اورظاہرکرتے ہو وہ سب جانتا ہے )"

            );

                break;



            case  "book1l":       book_data.setText("وظن داود انما فتناہ فاستغفر ربہ وخر راکعا واناب ( اور داود علیہ السلام سمجھ گۓ کہ ہم نے انہیں آزمایا ہے ، پھر تو وہ اپنے رب سے استغفار کرنے لگے اور عاجزی کرتے ہوۓ گرپڑے اور پوری طرح رجوع کیا )"

            );

                break;

            case  "book1m":       book_data.setText("ومن آياتہ اللیل والنھار والشمس والقمر لاتسجدوا للشمس ولا للقمر واسجدوا للہ الذی خلقھن ان کنتم ایاہ تعبدون ( اور دن رات اور سورج چاند بھی اللہ تعالی کی نشانیوں میں سے ہیں ، تم سورج کو سجدہ نہ کرو اور نہ ہی چاند کو بلکہ اللہ تعالی کوسجدہ کرو جس نے ان سب کوپیدا فرمایا ہے ، اگر تم اسی کی عبادت کرتے ہو )"
            );

                break;

            case  "book1n":       book_data.setText("اذا تتلی علیہم آیات الرحمن خروا سجدا وبکیا ( ان کے سامنے جب اللہ رحمان کی آیتوں کی تلاوت کی جاتی تھی تویہ سجدہ کرتے روتے گڑگڑاتے گرپڑتے تھے )"

            );

                break;














            case  "book2":       book_data.setText("پوراقرآن تیس پاروں پر مشتمل ہے۔\n" +
                    "\n" +
                    "•  قرآن میں کل” ۱۱۴“ سورے ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں ”۶۲۳۶“آیتیں ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل” ۱۰۱۵۰۳۰“نقطے ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۹۳۲۴۳“فتحہ(زبر )ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۳۹۵۸۶“ کسرہ (زیر ) ہیں ۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۴۸۰۸“ضمہ (پیش ) ہیں ۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۱۹۲۵۳“تشدید ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۳۲۳۶۷۱“حروف استعمال ہوئے ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۱۷۷۱“عدد ”مد“ ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۷۷۷۰“کلمہ استعمال ہوئے ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۱۰۰۰“ رکوع ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۱۲۰“”حزب “ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں ”۱۱۵“ لفظ” بسم اللّٰہ“ آیا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں ”۱۱۴“ بسم اللّٰہ الرحمن الرحیم آیا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں کل” ۵۰۹۸“ وقف ہیں۔\n" +
                    "\n" +
                    "•  قرآن میں کل”۷۰“ بار لفظ ”قرآن “ آیا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے بڑا سورہ ”بقرہ “ ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے چھوٹا سورہ ” کوثر “ ہے ۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے بڑی آیت سورہ بقرہ کی آیت ”۲۸۲“ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے چھوٹی آیت سورہ رحمن کی آیت” مُدْہٰامَّتٰان“ ہے\n" +
                    "\n" +
                    "•  قرآن میں سب سے بڑا کلمہ ”فَاٴَسْقَیْنٰاکُمُوہ“ ہے ۔(سورہ حجر/۲۲(\n" +
                    "\n" +
                    "•  قرآن میں سب سے چھوٹا کلمہ ”با“ بسم اللّٰہ ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے زیادہ حرف ”الف“استعمال ہوا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے کم حرف ”ظاء“ استعمال ہوا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے بہترین سورہ ”یٰس“ ہے۔\n" +
                    "\n" +
                    "•  وسط کلمہ قرآن ”وَلْیَتَلَطَّفْ “ہے جو سورہ کہف آیہ ۱۹میں آیاہے۔\n" +
                    "\n" +
                    "•  سورہ حمد کو ام القرآن اور فاتحۃ القرآن کہا جاتا ہے ۔\n" +
                    "\n" +
                    "•  قرآن میں پانچ سورہ ہیں جو ”الحمد للّٰہ “سے شروع ہوتے ہی( ۱۔حمد، ۲۔انعام، ۳۔کہف،۴۔سباٴ ،۵۔فاطر )\n" +
                    "\n" +
                    "•  قرآن میں چار سورہ ہیں جو” انّا “‘سے شروع ہوتے ہیں( فتح ، نوح ، قدر کوثر)\n" +
                    "\n" +
                    "•  قرآن میں اسراء ، حدید ، حشر ، صف ، جمعہ ، تغابن اور اعلیٰ کو سورہ مسبحات کہا جاتا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں ”۸۶“ سورہ مکی اور ”۲۸ “ سورہ مدنی ہیں۔\n" +
                    "\n" +
                    "•  سورہ ”یٰس“ کو قلب قرآن کہا جاتا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں ۷ سورے ”اذا “ سے شروع ہوئے ہیں (واقعہ،منافقون، تکویر، انفطار ، انشقاق،نصراور زلزال(\n" +
                    "\n" +
                    "•  قرآن میں فقط ایک سورہ ہے جو” بسم اللّٰہ الرحمن الرحیم “سے شروع نہیں ہوا ہے ،وہ سورہ توبہ ہے۔\n" +
                    "\n" +
                    "•  قرآن میں۲۰سورے ہیں جوقسم سے شروع ہوئے ہیں (عصر، عادیات، تین ، ضحیٰ، شمس ،بلد ،فجر ،طارق، بروج ، نازعات ،مرسلات، قیامت ، نجم، طور، ذاریات ، صافات، ن، ص،ق، اور لیل(\n" +
                    "\n" +
                    "•  قرآن میں پانچ سورے ”قل “ سے شروع ہوئے ہیں ( جن ،کافرون، اخلاص ، فلق اور ناس)\n" +
                    "\n" +
                    "•  سورہ نمل میں دو ”بسم اللّٰہ الرحمن الرحیم “آیا ہے۔\n" +
                    "\n" +
                    "•  قرآن میں ۲۹ سور ے حروف مقطعات سے شروع ہوئے ہیں۔\n" +
                    "\n" +
                    "•  سورہ ”زمر “ کے پہلی آیت اور آخری آیت میں لفظ ”اللہ “ آیا ہے۔\n" +
                    "\n" +
                    "•  سورہ مجادلہ کے تمام آیتوں میں لفظ اللّٰہ آیا ہے ۔\n" +
                    "\n" +
                    "•  قرآن کے تیسویں پارے میں ۳۷ سورے ہیں۔\n" +
                    "\n" +
                    "•  ”سورہ دہر“ اہلبیت علیہم السلام کی شان میں نازل ہواہے۔\n" +
                    "\n" +
                    "•  امام حسین علیہ السلام کا سر مبارک نوک نیزہ پر شام میں جس آیت کی تلاوت کی تھی وہ ”سورہ کہف “کی ۹ ویں آیت ہے۔\n" +
                    "\n" +
                    "•  سورہ اسراء کی آیت نمبر ۷۸ نماز یومیہ(پانچ وقت) کے بارے میں ہے۔\n" +
                    "\n" +
                    "•  آیہ مباہلہ سورہ”آل عمران“ آیت نمبر ۶۱ہے۔\n" +
                    "\n" +
                    "•  سورہ بقرہ آیت نمبر ۱۴۴،تغیر قبلہ کے بارے میں ہے۔\n" +
                    "\n" +
                    "•  قرآن میں سب سے زیادہ حضرت موسیٰ کا نام آیا ہے (۱۳۶مرتبہ)\n" +
                    "\n" +
                    "•  قرآن میں کل ۲۶پیغمبروں کے نام ذکر ہوئے ہیں:( حضرت آدم ، ادریس، نوح ، ہود ، صالح ، لوط ، ابراہیم ، اسماعیل ، یعقوب ، اسحاق، یوسف،ایوب ، یونس ، شعیب، موسیٰ ، ہارون، داوود ، سلیمان ، الیاس ، الیسع، ذوالکفل، عزیر ، زکریا ، یحییٰ عیسیٰ وہمارے نبی حضرت محمد مصطفیٰ ( علی نبینا و آلہ وعلیہم السلام اجمعین(\n" +
                    "\n" +
                    "•  رسول اکرم (ص) کااسم مبارک قرآن میں۵ ،بار آیا ہے، ۴ بار محمد (ص)اور ایک بار احمد(ص(\n" +
                    "\n" +
                    "•  قرآن میں سب سے کم جناب یونس کا نام آیا ہے ”فقط دو بار“۔\n" +
                    "\n" +
                    "•  سب سے زیادہ پیغمبروں کے نام سورہ ”انبیاء“ میں آیا ہے ۱۶،نبیوں کے نام ہیں․\n" +
                    "\n" +
                    "•  سب سے پہلے حضرت داؤد نے زرہ بنائی ۔\n" +
                    "\n" +
                    "•  سحر و جادو کا رواج جناب موسیٰ کے زمانہ میں وجود میں آیا۔\n" +
                    "\n" +
                    "•  سب سے پہلے جناب سلیمان علیہ السلام نے (بسم اللّٰہ الرّحمن الرّحیم ) لکھا۔\n" +
                    "\n" +
                    "•  سب سے پہلے جو آیت حضرت رسول خدا (ص)پر نازل ہوئی وہ سورہ علق کی پہلی پانچ آئتیں تھیں۔\n" +
                    "\n" +
                    "•  پہلی آیت جو حرمت شراب پر نازل ہوئی وہ سورہ بقرہ کی آیت نمبر ۱۲۹ہے\n" +
                    "\n" +
                    "•  اولین دعاجوقرآن میں آیاہے وہ سورہ بقرہ کی آیت ۱۲۶ ہے\n" +
                    "\n" +
                    "•  آخریسورہ جو پیغمبراکرم (ص) پر نازل ہوا وہ ”سورہ نصر “ہے۔\n" +
                    "\n" +
                    "•  آخری سورہ جومدینہ میں نازل ہوا وہ ”سورہ نصر “ہے۔\n" +
                    "\n" +
                    "•  آخری سورہ جو مکہ میں نازل ہو اوہ ”سورہ روم “ہے۔\n" +
                    "\n" +
                    "•  قرآن میں ۱۱۴ بار لفظ ”رحیم “ آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں ۶۷بار لفظ”صلوٰۃ“آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ ”آخرت“۱۱۵ بار آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ ”دنیا“۱۱۵ بار آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”یوم “۳۶۵بار بیان ہواہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”شھر“(مہینہ)۱۲بار آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”رحمان“۵۷بار آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”اللہ“تمام سوروں میں آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”سورہ“۱۰بار استعمال ہواہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”قلم“۴باراستعمال ہواہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ ”اللہ“۲۷۰۷بار آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”امام“۱۲مرتبہ آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”حیات“۱۴۵بارآیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں لفظ”موت“۱۴۵بارآیاہے۔\n" +
                    "\n" +
                    "•  دو عورتوں کو قرآن نے نمونے کے طور پر پیش کیاہے وہ ”آسیہ زن فرعون“ اور”مریم مادرحضرت عیسیٰ علیہ السلام“ہیں۔\n" +
                    "\n" +
                    "•  وہ دو عورتیں جن کی برائی قرآن نے بیان کیاہے وہ”جناب لوط اور جناب نوح کی بیویاں“ہیں۔\n" +
                    "\n" +
                    "•  جناب ”مریم “کانام قرآن میں ۳۴مرتبہ آیاہے۔\n" +
                    "\n" +
                    "•  قرآن میں کسی عورت کانام نہیں آیاہے فقط” جناب مریم “کا۔\n" +
                    "\n" +
                    "•  ان بتوں کے نام قرآن میں آیا ہے”البعل ،سواع،العجل،العزی، لات، منات،ود،یعوق، نسر،انصاب اوریغوث“۔\n" +
                    "\n" +
                    "•  قرآن میں پانچ سوروں کے نام حیوانوں کے اوپر ہیں( نمل ، عنکبوت، نحل،بقرہ اور فیل (\n" +
                    "\n" +
                    "•  قرآن میں جناب جبرئیل کانام فقط ۳ بار آیاہے۔\n" +
                    "\n" +
                    "•  ان فرشتوں کے نام جن کاذکر قرآن میں ہواہے”جبرئیل ،ھاروت، ماروت، میکال،مالک“\n" +
                    "\n" +
                    "•  جن بہشتی نہروں کے نام قرآن میں ذکر ہوئے ہیں وہ یہ ہیں”کافوریہ ، زنجبیلیہ، سلسبیل ،کوثراور تسنیم “\n" +
                    "\n" +
                    "•  قرآن ۲۳سال کی مدت تک حضرت رسول خدا (صلی اللہ علیہ وآلہ وبارک وسلم) پر نازل ہوا ہے۔\n" +
                    "\n" +
                    "•  سب سے پہلے قرآن میں ابو الاسود دوئلی نے اعراب لگایا۔\n" +
                    "\n" +
                    "•  سب سے پہلے مفسر قرآن حضرت علی علیہ السلام ہیں۔\n" +
                    "\n" +
                    "•  سب سے پہلے تفسیر قرآن کی کتاب سعید بن جبیر نے تالیف کیا۔\n" +
                    "\n" +
                    "•  سب سے پہلے قرآن میں ابو الاسود دوئلی نے نقطہ لگایا ہے۔\n" +
                    "\n" +
                    "•  سب سے پہلے عبداللہ بن مسعود نے مکہ میں بالاعلان قرآن پڑھا ۔\n" +
                    "\n" +
                    "•  سب سے پہلے سلمان فارسی نے سورہ حمد کا ترجمہ فارسی زبان میں کیا۔"

            );

                break;

            case  "book3":       book_data.setText("قرآن مجید کی عبارت گفتگو کے انداز میں واقع ہوئی ہے۔ اسی لئے اہل علم نے اس کی عبارت کے ٹھہرنے نہ ٹھہرنے کی علامتیں مقرر کر دی ہیں، ان علامات کو رموز اوقاف قرآن مجید کہتے ہیں۔ ضروری ہے کہ قرآن مجید کی تلاوت کرنے والے ان رموز کو ملحوظ رکھیں اور وہ یہ ہیں:\n" +

                    "جہاں بات پوری ہو جاتی ہے ، وہاں چھوٹا سا دائرہ بنادیتے ہیں۔ یہ حقیقت میں گول ’’ت‘‘ ہے۔ جو بصورت ’’ۃ ‘‘ لکھی جاتی ہے اور یہ وقفِ تام کی علامت ہے یعنی اس پر ٹھہرنا چاہئے، اب ’’ۃ ‘‘ تو نہیں لکھی جاتی البتہ چھوٹا سا دائرہ بنادیا جاتا ہے ،اسی کو آیت کہتے ہیں۔\n" +
                    "م\n" +
                    " یہ علامت وقفِ لازم کی ہے اس پر ضرور ٹھہرنا چاہیے، اگر نہ ٹھہرا جائے تو احتمال ہے کہ مطلب کچھ کاکچھ ہو جائے۔ اس کی مثال اردو میں یوں سمجھنی چاہیے کہ مثلاً کسی کو یہ کہنا ہو کہ ’’ اٹھو، مت بیٹھو‘‘ جس میں اٹھنے کا امر اور بیٹھنے کی نہی ہے تو ’’اٹھو‘‘پر ٹھہرنا لازم ہے، اگرنہ ٹھہرا جائے تو ’’اٹھو مت بیٹھو‘‘ ہو جائے گا۔ جس میں اٹھنے کی نہی اور بیٹھنے کے امر کا احتمال ہے اور یہ قائل کے مطلب کے خلاف ہو جائے گا۔\n" +
                    "ط\n" +
                    " یہ وقفِ مطلق کی علامت ہے اس پر ٹھہرنا چاہیے مگر یہ علامت وہاں ہوتی ہے جہاں مطلب تمام نہیں ہوتا اور بات کہنے والا ابھی کچھ اور کہنا چاہتا ہے ۔\n" +
                    "ج\n" +
                    "یہ وقفِ جائز کی علامت ہے یہاں ٹھہرنا بہتر اور نہ ٹھہرنا جائز ہے ۔\n" +
                    "ز\n" +
                    "یہ وقفِ مجوز کی علامت ہے یہاں نہ ٹھہرنا بہتر ہے ۔\n" +
                    "ص\n" +
                    "یہ وقفِ مرخص کی علامت ہے۔یہاں ملاکرپڑھناچاہئے،لیکن اگر کوئی تھک کر ٹھہر جائے تو رخصت ہے ۔ معلوم رہے کہ ’’ ص‘‘ پر ملا کر پڑھنا ’’ز‘‘ کی نسبت زیادہ ترجیح رکھتا ہے ۔\n" +
                    "صلے\n" +
                    "یہ ’’ اَلْوَصْلُ اَوْلٰی ‘‘کا اختصار ہے ،یعنی یہاں ملا کر پڑھنا بہتر ہے ۔\n" +
                    "ق\n" +
                    "یہ ’’قِیْلَ عَلَیْہِ الْوَقْفْ‘کاخلاصہ ہے یہاں ٹھہرنا نہیں چاہیے۔\n" +
                    "صل\n" +
                    "یہ ’’قَدْ یُوْصَلُ‘‘ کی علامت ہے یعنی یہاں کبھی ٹھہرا بھی جاتا ہے اور کبھی نہیں بھی ٹھہراجاتا، لیکن ٹھہرنا بہتر ہے۔\n" +
                    "قف\n" +
                    "یہ لفظِ ’’قِفْ‘‘ہے جس کے معنی ہیں ’’ٹھہرجاؤ ‘‘اور یہ علامت وہاں استعمال کی جاتی ہے جہاں پڑھنے والے کے ملا کر پڑھنے کااحتمال ہو۔\n" +
                    "س یا سکتہ\n" +
                    "یہ دونوں سکتہ کی علامات ہیں یہاں اس طرح ٹھہرنا چاہئے کہ آوازٹوٹ جائے مگر سانس نہ ٹوٹنے پائے۔\n" +
                    "وقفۃ\n" +
                    "یہ بھی سکتہ کی علامت ہے البتہ یہاں ماقبل دونوں علامات’’س یا سکتہ‘‘کی نسبت زیادہ ٹھہرنا چاہیے اور سانس بھی نہ ٹوٹے۔سکتہ اور وقفہ میں یہی فرق ہے کہ سکتہ میں کم اور وقفہ میں زیادہ ٹھہرا جاتا ہے۔\n" +
                    "لا\n" +
                    "’’لا‘‘کے معنی ’’نہیں‘‘ہیں،یہ علامت کہیں آیت کے اوپر استعمال کی جاتی ہے اور کہیں عبارت کے اندر۔ عبارت کے اندر ہو تو ہر گز نہیں ٹھہرنا چاہئے البتہ آیت کے اوپر ہو تواس پرٹھہرنے یانہ ٹھہرنے میں اختلاف ہے لیکن ٹھہرا جائے یا نہ ٹھہرا جائے اس سے مطلب میں خلل واقع نہیں ہوتا۔\n" +
                    "ك\n" +
                    "یہ ’’کَذٰلِکَ‘‘ کی علامت ہے یعنی اس سے پہلے جوعلامتِ وقف ہے یہاں بھی وہی سمجھی جائے۔\n" +
                    "اگرکوئی عبارت اِن تین تین نقطوں کے درمیان ہوتوپڑھنے والے کواختیار ہے کہ پہلے تین نقطوں پروقف کرکے دو سرے تین نقطوں پروقف نہ کرے یا پہلے تین نقطوں پروقف نہ کرکے دوسرے تین نقطوں پر وقف کرے۔ اس قسم کی عبارت کو معانقہ یا مراقبہ کہتے ہیں۔"
            );

                break;












            case  "book6":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;
            case  "book7":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;
            case  "book8":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;
            case  "book9":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;
            case  "Hadeesbook1":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;


            case  "Hadeesbook2":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;


            case  "Hadeesbook3":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");

                break;

            case  "Hadeesbook4":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");


                break;

            case  "Hadeesbook5":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");


                break;

                case  "Hadeesbook6":       book_data.setText("\n" +
                    "The rise of Islam began with the Prophet Muhammad, who was born in about 570 in the city of Mecca, in central western Arabia. From about the age of forty until shortly before his death in 632 Muhammad received frequent revelations from Allah delivered through the angel Gabriel. These were written down into 114 chapters or suras and collected together a generation after the death of Muhammad. The revelations are collectively known as the Qur'an, the sacred book of Islam.\n" +
                    "A second source of authority for Muslims is the Hadith (which literally means \"statement\") . The Hadith consists of a collection of sayings and deeds of the Prophet and his companions which were transmitted by a chain of authorities and written down between the ninth and eleventh centuries. (Individual sayings or traditions of the prophet and his companions are also known as hadith.) The developer set by the Prophet as recorded in the Hadith is known as the Sunnah, a term that literally means \"w ell-trodden path\". The Sunnah provides the normative basis upon which Muslims conduct their lives.\n" +
                    "\n" +
                    "The main sectarian division in Islam is between the Sunni and Shi'a traditions. Sunni and Shi'a share the same prophetic revelatory event described in the Qur'an and the Sunnah: they each accept as fundamental Allah's unity and the mission and mes sage of Muhammad. The division between the two traditions derives from the question of who is authorised to rule over the community of Muslims (Ummah). For the Sunni, authority to rule was originally in the hands of the community , which appointed a caliph (vice-regent/president) to rule on its behalf. They recognise the first four caliphs as Muhammad's legitimate successors.\n" +
                    "\n" +
                    "The Shi'a, however, placed authority solely in the hands of the fourth caliph, Ali, who was also the Prophet's cousin and son-in-law, and his descendants. Shi'ism has developed its own system of law and theology; its own clergy; festivals and places of pilgrimage; and a special religious ethos characterised by a fervour to suffer for the cause.\n" +
                    "\n" +
                    "In spite of the division between Sunni and Shi'a, Islam has avoided the extensive fractural divisions that have occurred in some other major world religions. There have of course been various splits, but many of these were the result of slightly variant approaches to jurisprudence and theology rather than actual sectarian divisions caused by doctrinal differences. The various jurisprudential and theological schools in Islam tend to be referred to with the Arabic word \"Madhhab\" (which means \"a path that is walked along\") since the term does not suggest any value judgements with regard to the style of Islam that is being practised. Muslims who affiliate themselves to different theological or jurisprudential madhhabs will worship in the same mosque. There is no sense of denominational difference here, and it is inappropriate to regard the different madhhabs as sects.\n" +
                    "\n" +
                    "The terms sect or independent group can, however, be used to refer to those groups which, through developing doctrines and practices clearly at odds with Qur'anic teaching or the traditions of the Prophet, have placed themselves outside of main stream Islam. Four such major sects have emerged from within the Sunni tradition: Kharijiyyah, Mu'tazilah, Wahhabiyyah and Ahmadiyyah. Three have arisen from within Shi'a: Isma'iliyyah, Nusayriyyah and Qarmatiyyah. These are all regarded by orthodox Muslims as heretical. Other groups that have emerged from within the Shi'a tradition are the Druzes, the Babis and the Baha'is. Although these groups emerged from within the Shi'a branch of Islam they do not consider themselves to be Muslims but are independent traditions in their own right.");


                break;






        }


        findViewById(R.id.back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}