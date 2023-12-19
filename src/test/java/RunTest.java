import listeners.TestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Optional;
import org.testng.annotations.Test;
import org.testng.annotations.Parameters;
import steps.Steps;
import utils.Initialize;


@Listeners(TestListener.class)
public class RunTest extends Initialize {

    Steps user = new Steps();
    @Parameters({"search"})
    @Test
    public void runTest(@Optional("BtcTurk")String search) {
        user.openBrowser("GoogleUrl", "GoogleTitle");
        user.searchOnGoogle(search);
        user.saveGoogleResultData("ContentCount");
        user.navigateTo("YandexUrl", "YandexTitle");
        user.searchOnYandex(search);
        user.saveYandexResultData("ContentCount");
        user.checkEngineResultData();
    }
}
