package domainLayer.test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BoardlinkTest.class, BoardsetUpTransitSquaresTest.class, CupisDualRollTest.class,
		CupisThirdDualRollTest.class, CuprolledEvenTest.class, CuprolledOddTest.class, CuprollTest.class,
		GoToJailChanceCardcardActionTest.class, PlayerattemptPurchaseTest.class, PlayermoveOneByOneForTest.class,
		PlayertakeTurnTest.class, PlayertryToGetOutOfJailTest.class, PlayerwhichLayerTest.class,
		TransitSquaregetBrotherTest.class, TransitSquaregetNextSquareTest.class, TransitSquaresetOwnerTest.class, 
		PlayerteleportToLandTest.class, PlayerkeepCardTest.class, PlayeruseCardTest.class, PlayergoToJailTest.class,
		PlayeraddPropertyTest.class})
public class AllTests {

}
