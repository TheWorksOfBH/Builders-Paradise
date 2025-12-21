package github.theworksofbh.buildersparadise.mixins;

import com.llamalad7.mixinextras.injector.wrapmethod.WrapMethod;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.gui.components.SplashRenderer;
import net.minecraft.client.resources.SplashManager;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.time.Year;

@Mixin(SplashManager.class)
public abstract class SplashManagerMixins {

    @Unique
    private static final MonthDay NOTCH_BIRTHDAY = MonthDay.of(Month.JUNE, 1);
    @Unique
    private static final MonthDay JEB_BIRTHDAY = MonthDay.of(Month.MAY, 18);
    @Unique
    private static final MonthDay DINNERBONE_BIRTHDAY = MonthDay.of(Month.JULY, 23);
    @Unique
    private static final MonthDay AMERICAN_INDEPENDENCE = MonthDay.of(Month.JULY, 4);
    @Unique
    private static final MonthDay UK_INDEPENDENCE = MonthDay.of(Month.MAY, 1);
    @Unique
    private static final MonthDay FRANCE_INDEPENDENCE = MonthDay.of(Month.JULY, 14);
    @Unique
    private static final MonthDay ISRAEL_INDEPENDENCE = MonthDay.of(Month.MAY, 14); // Not the actual date, but I really do not know how to parse Jewish calendar dates through MonthDay
    @Unique
    private static final MonthDay STAR_WARS = MonthDay.of(Month.MAY, 4);
    @Unique
    private static final MonthDay MINECRAFT_ANNIVERSARY = MonthDay.of(Month.MAY, 17);
    @Unique
    private static final LocalDate MINECRAFT_CREATION = LocalDate.of(2009, Month.MAY, 17);
    @Unique
    private static final MonthDay EASTER = MonthDay.from(getEasterMonthDay(Year.now().getValue()));

    @Unique
    private static String ordinal(int number) {
        int mod100 = number % 100;
        if (mod100 >= 11 && mod100 <= 13) {
            return number + "th";
        }

        return switch (number % 10) {
            case 1 -> number + "st";
            case 2 -> number + "nd";
            case 3 -> number + "rd";
            default -> number + "th";
        };
    }

    @Unique
    private static LocalDate getEasterSunday(int year) {
        int a = year % 19;
        int b = year / 100;
        int c = year % 100;
        int d = b / 4;
        int e = b % 4;
        int f = (b + 8) / 25;
        int g = (b - f + 1) / 3;
        int h = (19 * a + b - d - g + 15) % 30;
        int i = c / 4;
        int k = c % 4;
        int l = (32 + 2 * e + 2 * i - h - k) % 7;
        int m = (a + 11 * h + 22 * l) / 451;
        int month = (h + l - 7 * m + 114) / 31; // 3 = March, 4 = April
        int day = ((h + l - 7 * m + 114) % 31) + 1;

        return LocalDate.of(year, month, day);
    }

    @Unique
    private static MonthDay getEasterMonthDay(int year) {
        LocalDate easter = getEasterSunday(year);
        return MonthDay.from(easter);
    }

    @WrapMethod(method = "getSplash")
    private SplashRenderer addCustomSplashTexts(Operation<SplashRenderer> original) {
        MonthDay today = MonthDay.now();
        LocalDate todayWithYear = LocalDate.now();
        Component splash;
        if (today.equals(NOTCH_BIRTHDAY)) {
            splash = SplashManager.literalSplash("Happy birthday Notch!");
        } else if (today.equals(JEB_BIRTHDAY)) {
            splash = SplashManager.literalSplash("§1H§2a§3p§4p§5y §6b§7i§8r§9t§ah§bd§ca§dy §ej§fe§0b§1_§2!");
        } else if (today.equals(DINNERBONE_BIRTHDAY)) {
            splash = SplashManager.literalSplash("¡ǝuoqɹǝuuᴉp ʎɐpɥʇɹᴉq ʎddɐH");
        } else if (today.equals(AMERICAN_INDEPENDENCE)) {
            splash = SplashManager.literalSplash("America, fuck yeah!");
        } else if (today.equals(UK_INDEPENDENCE)) {
            splash = SplashManager.literalSplash("Britannia rules the waves!");
        } else if (today.equals(FRANCE_INDEPENDENCE)) {
            splash = SplashManager.literalSplash("Vive la France!");
        } else if (today.equals(ISRAEL_INDEPENDENCE)) {
            splash = SplashManager.literalSplash("עם ישראל חי!");
        } else if (today.equals(STAR_WARS)) {
            splash = SplashManager.literalSplash("May the fourth be with you!");
        } else if (today.equals(MINECRAFT_ANNIVERSARY)) {
            int years = todayWithYear.getYear() - MINECRAFT_CREATION.getYear();
            String ordinalYears = ordinal(years);

            splash = SplashManager.literalSplash("Happy " + ordinalYears + " birthday Minecraft!");
        } else if (today.equals(EASTER)) {
            splash = SplashManager.literalSplash("Hoppy Easter!");
        } else {
            splash = null;
        }

        if (splash == null) {
            return original.call();
        } else {
            return new SplashRenderer(splash);
        }
    }

}
