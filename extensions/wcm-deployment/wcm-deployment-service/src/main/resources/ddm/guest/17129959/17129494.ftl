#set ($ddl_records_local_service = $serviceLocator.findService("com.liferay.portlet.dynamicdatalists.service.DDLRecordLocalService"))
#set ($records = $ddl_records_local_service.getRecords(17128470))

<style>
	.pt-page-moveToLeft{-webkit-animation:moveToLeft .6s ease both;animation:moveToLeft .6s ease both}.pt-page-moveFromLeft{-webkit-animation:moveFromLeft .6s ease both;animation:moveFromLeft .6s ease both}.pt-page-moveToRight{-webkit-animation:moveToRight .6s ease both;animation:moveToRight .6s ease both}.pt-page-moveFromRight{-webkit-animation:moveFromRight .6s ease both;animation:moveFromRight .6s ease both}.pt-page-moveToTop{-webkit-animation:moveToTop .6s ease both;animation:moveToTop .6s ease both}.pt-page-moveFromTop{-webkit-animation:moveFromTop .6s ease both;animation:moveFromTop .6s ease both}.pt-page-moveToBottom{-webkit-animation:moveToBottom .6s ease both;animation:moveToBottom .6s ease both}.pt-page-moveFromBottom{-webkit-animation:moveFromBottom .6s ease both;animation:moveFromBottom .6s ease both}.pt-page-fade{-webkit-animation:fade .7s ease both;animation:fade .7s ease both}.pt-page-moveToLeftFade{-webkit-animation:moveToLeftFade .7s ease both;animation:moveToLeftFade .7s ease both}.pt-page-moveFromLeftFade{-webkit-animation:moveFromLeftFade .7s ease both;animation:moveFromLeftFade .7s ease both}.pt-page-moveToRightFade{-webkit-animation:moveToRightFade .7s ease both;animation:moveToRightFade .7s ease both}.pt-page-moveFromRightFade{-webkit-animation:moveFromRightFade .7s ease both;animation:moveFromRightFade .7s ease both}.pt-page-moveToTopFade{-webkit-animation:moveToTopFade .7s ease both;animation:moveToTopFade .7s ease both}.pt-page-moveFromTopFade{-webkit-animation:moveFromTopFade .7s ease both;animation:moveFromTopFade .7s ease both}.pt-page-moveToBottomFade{-webkit-animation:moveToBottomFade .7s ease both;animation:moveToBottomFade .7s ease both}.pt-page-moveFromBottomFade{-webkit-animation:moveFromBottomFade .7s ease both;animation:moveFromBottomFade .7s ease both}.pt-page-moveToLeftEasing{-webkit-animation:moveToLeft .7s ease-in-out both;animation:moveToLeft .7s ease-in-out both}.pt-page-moveToRightEasing{-webkit-animation:moveToRight .7s ease-in-out both;animation:moveToRight .7s ease-in-out both}.pt-page-moveToTopEasing{-webkit-animation:moveToTop .7s ease-in-out both;animation:moveToTop .7s ease-in-out both}.pt-page-moveToBottomEasing{-webkit-animation:moveToBottom .7s ease-in-out both;animation:moveToBottom .7s ease-in-out both}@-webkit-keyframes moveToLeft{to{-webkit-transform:translateX(-100%)}}@keyframes moveToLeft{to{-webkit-transform:translateX(-100%);transform:translateX(-100%)}}@-webkit-keyframes moveFromLeft{from{-webkit-transform:translateX(-100%)}}@keyframes moveFromLeft{from{-webkit-transform:translateX(-100%);transform:translateX(-100%)}}@-webkit-keyframes moveToRight{to{-webkit-transform:translateX(100%)}}@keyframes moveToRight{to{-webkit-transform:translateX(100%);transform:translateX(100%)}}@-webkit-keyframes moveFromRight{from{-webkit-transform:translateX(100%)}}@keyframes moveFromRight{from{-webkit-transform:translateX(100%);transform:translateX(100%)}}@-webkit-keyframes moveToTop{to{-webkit-transform:translateY(-100%)}}@keyframes moveToTop{to{-webkit-transform:translateY(-100%);transform:translateY(-100%)}}@-webkit-keyframes moveFromTop{from{-webkit-transform:translateY(-100%)}}@keyframes moveFromTop{from{-webkit-transform:translateY(-100%);transform:translateY(-100%)}}@-webkit-keyframes moveToBottom{to{-webkit-transform:translateY(100%)}}@keyframes moveToBottom{to{-webkit-transform:translateY(100%);transform:translateY(100%)}}@-webkit-keyframes moveFromBottom{from{-webkit-transform:translateY(100%)}}@keyframes moveFromBottom{from{-webkit-transform:translateY(100%);transform:translateY(100%)}}@-webkit-keyframes fade{to{opacity:0.3}}@keyframes fade{to{opacity:0.3}}@-webkit-keyframes moveToLeftFade{to{opacity:0.3;-webkit-transform:translateX(-100%)}}@keyframes moveToLeftFade{to{opacity:0.3;-webkit-transform:translateX(-100%);transform:translateX(-100%)}}@-webkit-keyframes moveFromLeftFade{from{opacity:0.3;-webkit-transform:translateX(-100%)}}@keyframes moveFromLeftFade{from{opacity:0.3;-webkit-transform:translateX(-100%);transform:translateX(-100%)}}@-webkit-keyframes moveToRightFade{to{opacity:0.3;-webkit-transform:translateX(100%)}}@keyframes moveToRightFade{to{opacity:0.3;-webkit-transform:translateX(100%);transform:translateX(100%)}}@-webkit-keyframes moveFromRightFade{from{opacity:0.3;-webkit-transform:translateX(100%)}}@keyframes moveFromRightFade{from{opacity:0.3;-webkit-transform:translateX(100%);transform:translateX(100%)}}@-webkit-keyframes moveToTopFade{to{opacity:0.3;-webkit-transform:translateY(-100%)}}@keyframes moveToTopFade{to{opacity:0.3;-webkit-transform:translateY(-100%);transform:translateY(-100%)}}@-webkit-keyframes moveFromTopFade{from{opacity:0.3;-webkit-transform:translateY(-100%)}}@keyframes moveFromTopFade{from{opacity:0.3;-webkit-transform:translateY(-100%);transform:translateY(-100%)}}@-webkit-keyframes moveToBottomFade{to{opacity:0.3;-webkit-transform:translateY(100%)}}@keyframes moveToBottomFade{to{opacity:0.3;-webkit-transform:translateY(100%);transform:translateY(100%)}}@-webkit-keyframes moveFromBottomFade{from{opacity:0.3;-webkit-transform:translateY(100%)}}@keyframes moveFromBottomFade{from{opacity:0.3;-webkit-transform:translateY(100%);transform:translateY(100%)}}.pt-page-scaleDown{-webkit-animation:scaleDown .7s ease both;animation:scaleDown .7s ease both}.pt-page-scaleUp{-webkit-animation:scaleUp .7s ease both;animation:scaleUp .7s ease both}.pt-page-scaleUpDown{-webkit-animation:scaleUpDown .5s ease both;animation:scaleUpDown .5s ease both}.pt-page-scaleDownUp{-webkit-animation:scaleDownUp .5s ease both;animation:scaleDownUp .5s ease both}.pt-page-scaleDownCenter{-webkit-animation:scaleDownCenter .4s ease-in both;animation:scaleDownCenter .4s ease-in both}.pt-page-scaleUpCenter{-webkit-animation:scaleUpCenter .4s ease-out both;animation:scaleUpCenter .4s ease-out both}@-webkit-keyframes scaleDown{to{opacity:0;-webkit-transform:scale(0.8)}}@keyframes scaleDown{to{opacity:0;-webkit-transform:scale(0.8);transform:scale(0.8)}}@-webkit-keyframes scaleUp{from{opacity:0;-webkit-transform:scale(0.8)}}@keyframes scaleUp{from{opacity:0;-webkit-transform:scale(0.8);transform:scale(0.8)}}@-webkit-keyframes scaleUpDown{from{opacity:0;-webkit-transform:scale(1.2)}}@keyframes scaleUpDown{from{opacity:0;-webkit-transform:scale(1.2);transform:scale(1.2)}}@-webkit-keyframes scaleDownUp{to{opacity:0;-webkit-transform:scale(1.2)}}@keyframes scaleDownUp{to{opacity:0;-webkit-transform:scale(1.2);transform:scale(1.2)}}@-webkit-keyframes scaleDownCenter{to{opacity:0;-webkit-transform:scale(0.7)}}@keyframes scaleDownCenter{to{opacity:0;-webkit-transform:scale(0.7);transform:scale(0.7)}}@-webkit-keyframes scaleUpCenter{from{opacity:0;-webkit-transform:scale(0.7)}}@keyframes scaleUpCenter{from{opacity:0;-webkit-transform:scale(0.7);transform:scale(0.7)}}.pt-page-rotateRightSideFirst{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateRightSideFirst .8s both ease-in;animation:rotateRightSideFirst .8s both ease-in}.pt-page-rotateLeftSideFirst{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateLeftSideFirst .8s both ease-in;animation:rotateLeftSideFirst .8s both ease-in}.pt-page-rotateTopSideFirst{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateTopSideFirst .8s both ease-in;animation:rotateTopSideFirst .8s both ease-in}.pt-page-rotateBottomSideFirst{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateBottomSideFirst .8s both ease-in;animation:rotateBottomSideFirst .8s both ease-in}.pt-page-flipOutRight{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipOutRight .5s both ease-in;animation:flipOutRight .5s both ease-in}.pt-page-flipInLeft{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipInLeft .5s both ease-out;animation:flipInLeft .5s both ease-out}.pt-page-flipOutLeft{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipOutLeft .5s both ease-in;animation:flipOutLeft .5s both ease-in}.pt-page-flipInRight{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipInRight .5s both ease-out;animation:flipInRight .5s both ease-out}.pt-page-flipOutTop{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipOutTop .5s both ease-in;animation:flipOutTop .5s both ease-in}.pt-page-flipInBottom{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipInBottom .5s both ease-out;animation:flipInBottom .5s both ease-out}.pt-page-flipOutBottom{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipOutBottom .5s both ease-in;animation:flipOutBottom .5s both ease-in}.pt-page-flipInTop{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:flipInTop .5s both ease-out;animation:flipInTop .5s both ease-out}.pt-page-rotateFall{-webkit-transform-origin:0% 0%;transform-origin:0% 0%;-webkit-animation:rotateFall 1s both ease-in;animation:rotateFall 1s both ease-in}.pt-page-rotateOutNewspaper{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:rotateOutNewspaper .5s both ease-in;animation:rotateOutNewspaper .5s both ease-in}.pt-page-rotateInNewspaper{-webkit-transform-origin:50% 50%;transform-origin:50% 50%;-webkit-animation:rotateInNewspaper .5s both ease-out;animation:rotateInNewspaper .5s both ease-out}.pt-page-rotatePushLeft{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotatePushLeft .8s both ease;animation:rotatePushLeft .8s both ease}.pt-page-rotatePushRight{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotatePushRight .8s both ease;animation:rotatePushRight .8s both ease}.pt-page-rotatePushTop{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotatePushTop .8s both ease;animation:rotatePushTop .8s both ease}.pt-page-rotatePushBottom{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotatePushBottom .8s both ease;animation:rotatePushBottom .8s both ease}.pt-page-rotatePullRight{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotatePullRight .5s both ease;animation:rotatePullRight .5s both ease}.pt-page-rotatePullLeft{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotatePullLeft .5s both ease;animation:rotatePullLeft .5s both ease}.pt-page-rotatePullTop{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotatePullTop .5s both ease;animation:rotatePullTop .5s both ease}.pt-page-rotatePullBottom{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotatePullBottom .5s both ease;animation:rotatePullBottom .5s both ease}.pt-page-rotateFoldRight{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateFoldRight .7s both ease;animation:rotateFoldRight .7s both ease}.pt-page-rotateFoldLeft{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateFoldLeft .7s both ease;animation:rotateFoldLeft .7s both ease}.pt-page-rotateFoldTop{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateFoldTop .7s both ease;animation:rotateFoldTop .7s both ease}.pt-page-rotateFoldBottom{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateFoldBottom .7s both ease;animation:rotateFoldBottom .7s both ease}.pt-page-rotateUnfoldLeft{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateUnfoldLeft .7s both ease;animation:rotateUnfoldLeft .7s both ease}.pt-page-rotateUnfoldRight{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateUnfoldRight .7s both ease;animation:rotateUnfoldRight .7s both ease}.pt-page-rotateUnfoldTop{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateUnfoldTop .7s both ease;animation:rotateUnfoldTop .7s both ease}.pt-page-rotateUnfoldBottom{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateUnfoldBottom .7s both ease;animation:rotateUnfoldBottom .7s both ease}.pt-page-rotateRoomLeftOut{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateRoomLeftOut .8s both ease;animation:rotateRoomLeftOut .8s both ease}.pt-page-rotateRoomLeftIn{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateRoomLeftIn .8s both ease;animation:rotateRoomLeftIn .8s both ease}.pt-page-rotateRoomRightOut{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateRoomRightOut .8s both ease;animation:rotateRoomRightOut .8s both ease}.pt-page-rotateRoomRightIn{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateRoomRightIn .8s both ease;animation:rotateRoomRightIn .8s both ease}.pt-page-rotateRoomTopOut{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateRoomTopOut .8s both ease;animation:rotateRoomTopOut .8s both ease}.pt-page-rotateRoomTopIn{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateRoomTopIn .8s both ease;animation:rotateRoomTopIn .8s both ease}.pt-page-rotateRoomBottomOut{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateRoomBottomOut .8s both ease;animation:rotateRoomBottomOut .8s both ease}.pt-page-rotateRoomBottomIn{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateRoomBottomIn .8s both ease;animation:rotateRoomBottomIn .8s both ease}.pt-page-rotateCubeLeftOut{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateCubeLeftOut .6s both ease-in;animation:rotateCubeLeftOut .6s both ease-in}.pt-page-rotateCubeLeftIn{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateCubeLeftIn .6s both ease-in;animation:rotateCubeLeftIn .6s both ease-in}.pt-page-rotateCubeRightOut{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateCubeRightOut .6s both ease-in;animation:rotateCubeRightOut .6s both ease-in}.pt-page-rotateCubeRightIn{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateCubeRightIn .6s both ease-in;animation:rotateCubeRightIn .6s both ease-in}.pt-page-rotateCubeTopOut{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateCubeTopOut .6s both ease-in;animation:rotateCubeTopOut .6s both ease-in}.pt-page-rotateCubeTopIn{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateCubeTopIn .6s both ease-in;animation:rotateCubeTopIn .6s both ease-in}.pt-page-rotateCubeBottomOut{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateCubeBottomOut .6s both ease-in;animation:rotateCubeBottomOut .6s both ease-in}.pt-page-rotateCubeBottomIn{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateCubeBottomIn .6s both ease-in;animation:rotateCubeBottomIn .6s both ease-in}.pt-page-rotateCarouselLeftOut{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateCarouselLeftOut .8s both ease;animation:rotateCarouselLeftOut .8s both ease}.pt-page-rotateCarouselLeftIn{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateCarouselLeftIn .8s both ease;animation:rotateCarouselLeftIn .8s both ease}.pt-page-rotateCarouselRightOut{-webkit-transform-origin:0% 50%;transform-origin:0% 50%;-webkit-animation:rotateCarouselRightOut .8s both ease;animation:rotateCarouselRightOut .8s both ease}.pt-page-rotateCarouselRightIn{-webkit-transform-origin:100% 50%;transform-origin:100% 50%;-webkit-animation:rotateCarouselRightIn .8s both ease;animation:rotateCarouselRightIn .8s both ease}.pt-page-rotateCarouselTopOut{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateCarouselTopOut .8s both ease;animation:rotateCarouselTopOut .8s both ease}.pt-page-rotateCarouselTopIn{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateCarouselTopIn .8s both ease;animation:rotateCarouselTopIn .8s both ease}.pt-page-rotateCarouselBottomOut{-webkit-transform-origin:50% 0%;transform-origin:50% 0%;-webkit-animation:rotateCarouselBottomOut .8s both ease;animation:rotateCarouselBottomOut .8s both ease}.pt-page-rotateCarouselBottomIn{-webkit-transform-origin:50% 100%;transform-origin:50% 100%;-webkit-animation:rotateCarouselBottomIn .8s both ease;animation:rotateCarouselBottomIn .8s both ease}.pt-page-rotateSidesOut{-webkit-transform-origin:-50% 50%;transform-origin:-50% 50%;-webkit-animation:rotateSidesOut .5s both ease-in;animation:rotateSidesOut .5s both ease-in}.pt-page-rotateSidesIn{-webkit-transform-origin:150% 50%;transform-origin:150% 50%;-webkit-animation:rotateSidesIn .5s both ease-out;animation:rotateSidesIn .5s both ease-out}.pt-page-rotateSlideOut{-webkit-animation:rotateSlideOut 1s both ease;animation:rotateSlideOut 1s both ease}.pt-page-rotateSlideIn{-webkit-animation:rotateSlideIn 1s both ease;animation:rotateSlideIn 1s both ease}@-webkit-keyframes rotateRightSideFirst{40%{-webkit-transform:rotateY(15deg);opacity:.8;-webkit-animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);opacity:0}}@keyframes rotateRightSideFirst{40%{-webkit-transform:rotateY(15deg);transform:rotateY(15deg);opacity:.8;-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);transform:scale(0.8) translateZ(-200px);opacity:0}}@-webkit-keyframes rotateLeftSideFirst{40%{-webkit-transform:rotateY(-15deg);opacity:.8;-webkit-animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);opacity:0}}@keyframes rotateLeftSideFirst{40%{-webkit-transform:rotateY(-15deg);transform:rotateY(-15deg);opacity:.8;-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);transform:scale(0.8) translateZ(-200px);opacity:0}}@-webkit-keyframes rotateTopSideFirst{40%{-webkit-transform:rotateX(15deg);opacity:.8;-webkit-animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);opacity:0}}@keyframes rotateTopSideFirst{40%{-webkit-transform:rotateX(15deg);transform:rotateX(15deg);opacity:.8;-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);transform:scale(0.8) translateZ(-200px);opacity:0}}@-webkit-keyframes rotateBottomSideFirst{40%{-webkit-transform:rotateX(-15deg);opacity:.8;-webkit-animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);opacity:0}}@keyframes rotateBottomSideFirst{40%{-webkit-transform:rotateX(-15deg);transform:rotateX(-15deg);opacity:.8;-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out}100%{-webkit-transform:scale(0.8) translateZ(-200px);transform:scale(0.8) translateZ(-200px);opacity:0}}@-webkit-keyframes flipOutRight{to{-webkit-transform:translateZ(-1000px) rotateY(90deg);opacity:0.2}}@keyframes flipOutRight{to{-webkit-transform:translateZ(-1000px) rotateY(90deg);transform:translateZ(-1000px) rotateY(90deg);opacity:0.2}}@-webkit-keyframes flipInLeft{from{-webkit-transform:translateZ(-1000px) rotateY(-90deg);opacity:0.2}}@keyframes flipInLeft{from{-webkit-transform:translateZ(-1000px) rotateY(-90deg);transform:translateZ(-1000px) rotateY(-90deg);opacity:0.2}}@-webkit-keyframes flipOutLeft{to{-webkit-transform:translateZ(-1000px) rotateY(-90deg);opacity:0.2}}@keyframes flipOutLeft{to{-webkit-transform:translateZ(-1000px) rotateY(-90deg);transform:translateZ(-1000px) rotateY(-90deg);opacity:0.2}}@-webkit-keyframes flipInRight{from{-webkit-transform:translateZ(-1000px) rotateY(90deg);opacity:0.2}}@keyframes flipInRight{from{-webkit-transform:translateZ(-1000px) rotateY(90deg);transform:translateZ(-1000px) rotateY(90deg);opacity:0.2}}@-webkit-keyframes flipOutTop{to{-webkit-transform:translateZ(-1000px) rotateX(90deg);opacity:0.2}}@keyframes flipOutTop{to{-webkit-transform:translateZ(-1000px) rotateX(90deg);transform:translateZ(-1000px) rotateX(90deg);opacity:0.2}}@-webkit-keyframes flipInBottom{from{-webkit-transform:translateZ(-1000px) rotateX(-90deg);opacity:0.2}}@keyframes flipInBottom{from{-webkit-transform:translateZ(-1000px) rotateX(-90deg);transform:translateZ(-1000px) rotateX(-90deg);opacity:0.2}}@-webkit-keyframes flipOutBottom{to{-webkit-transform:translateZ(-1000px) rotateX(-90deg);opacity:0.2}}@keyframes flipOutBottom{to{-webkit-transform:translateZ(-1000px) rotateX(-90deg);transform:translateZ(-1000px) rotateX(-90deg);opacity:0.2}}@-webkit-keyframes flipInTop{from{-webkit-transform:translateZ(-1000px) rotateX(90deg);opacity:0.2}}@keyframes flipInTop{from{-webkit-transform:translateZ(-1000px) rotateX(90deg);transform:translateZ(-1000px) rotateX(90deg);opacity:0.2}}@-webkit-keyframes rotateFall{0%{-webkit-transform:rotateZ(0deg)}20%{-webkit-transform:rotateZ(10deg);-webkit-animation-timing-function:ease-out}40%{-webkit-transform:rotateZ(17deg)}60%{-webkit-transform:rotateZ(16deg)}100%{-webkit-transform:translateY(100%) rotateZ(17deg)}}@keyframes rotateFall{0%{-webkit-transform:rotateZ(0deg);transform:rotateZ(0deg)}20%{-webkit-transform:rotateZ(10deg);transform:rotateZ(10deg);-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out}40%{-webkit-transform:rotateZ(17deg);transform:rotateZ(17deg)}60%{-webkit-transform:rotateZ(16deg);transform:rotateZ(16deg)}100%{-webkit-transform:translateY(100%) rotateZ(17deg);transform:translateY(100%) rotateZ(17deg)}}@-webkit-keyframes rotateOutNewspaper{to{-webkit-transform:translateZ(-3000px) rotateZ(360deg);opacity:0}}@keyframes rotateOutNewspaper{to{-webkit-transform:translateZ(-3000px) rotateZ(360deg);transform:translateZ(-3000px) rotateZ(360deg);opacity:0}}@-webkit-keyframes rotateInNewspaper{from{-webkit-transform:translateZ(-3000px) rotateZ(-360deg);opacity:0}}@keyframes rotateInNewspaper{from{-webkit-transform:translateZ(-3000px) rotateZ(-360deg);transform:translateZ(-3000px) rotateZ(-360deg);opacity:0}}@-webkit-keyframes rotatePushLeft{to{opacity:0;-webkit-transform:rotateY(90deg)}}@keyframes rotatePushLeft{to{opacity:0;-webkit-transform:rotateY(90deg);transform:rotateY(90deg)}}@-webkit-keyframes rotatePushRight{to{opacity:0;-webkit-transform:rotateY(-90deg)}}@keyframes rotatePushRight{to{opacity:0;-webkit-transform:rotateY(-90deg);transform:rotateY(-90deg)}}@-webkit-keyframes rotatePushTop{to{opacity:0;-webkit-transform:rotateX(-90deg)}}@keyframes rotatePushTop{to{opacity:0;-webkit-transform:rotateX(-90deg);transform:rotateX(-90deg)}}@-webkit-keyframes rotatePushBottom{to{opacity:0;-webkit-transform:rotateX(90deg)}}@keyframes rotatePushBottom{to{opacity:0;-webkit-transform:rotateX(90deg);transform:rotateX(90deg)}}@-webkit-keyframes rotatePullRight{from{opacity:0;-webkit-transform:rotateY(-90deg)}}@keyframes rotatePullRight{from{opacity:0;-webkit-transform:rotateY(-90deg);transform:rotateY(-90deg)}}@-webkit-keyframes rotatePullLeft{from{opacity:0;-webkit-transform:rotateY(90deg)}}@keyframes rotatePullLeft{from{opacity:0;-webkit-transform:rotateY(90deg);transform:rotateY(90deg)}}@-webkit-keyframes rotatePullTop{from{opacity:0;-webkit-transform:rotateX(-90deg)}}@keyframes rotatePullTop{from{opacity:0;-webkit-transform:rotateX(-90deg);transform:rotateX(-90deg)}}@-webkit-keyframes rotatePullBottom{from{opacity:0;-webkit-transform:rotateX(90deg)}}@keyframes rotatePullBottom{from{opacity:0;-webkit-transform:rotateX(90deg);transform:rotateX(90deg)}}@-webkit-keyframes rotateFoldRight{to{opacity:0;-webkit-transform:translateX(100%) rotateY(90deg)}}@keyframes rotateFoldRight{to{opacity:0;-webkit-transform:translateX(100%) rotateY(90deg);transform:translateX(100%) rotateY(90deg)}}@-webkit-keyframes rotateFoldLeft{to{opacity:0;-webkit-transform:translateX(-100%) rotateY(-90deg)}}@keyframes rotateFoldLeft{to{opacity:0;-webkit-transform:translateX(-100%) rotateY(-90deg);transform:translateX(-100%) rotateY(-90deg)}}@-webkit-keyframes rotateFoldTop{to{opacity:0;-webkit-transform:translateY(-100%) rotateX(90deg)}}@keyframes rotateFoldTop{to{opacity:0;-webkit-transform:translateY(-100%) rotateX(90deg);transform:translateY(-100%) rotateX(90deg)}}@-webkit-keyframes rotateFoldBottom{to{opacity:0;-webkit-transform:translateY(100%) rotateX(-90deg)}}@keyframes rotateFoldBottom{to{opacity:0;-webkit-transform:translateY(100%) rotateX(-90deg);transform:translateY(100%) rotateX(-90deg)}}@-webkit-keyframes rotateUnfoldLeft{from{opacity:0;-webkit-transform:translateX(-100%) rotateY(-90deg)}}@keyframes rotateUnfoldLeft{from{opacity:0;-webkit-transform:translateX(-100%) rotateY(-90deg);transform:translateX(-100%) rotateY(-90deg)}}@-webkit-keyframes rotateUnfoldRight{from{opacity:0;-webkit-transform:translateX(100%) rotateY(90deg)}}@keyframes rotateUnfoldRight{from{opacity:0;-webkit-transform:translateX(100%) rotateY(90deg);transform:translateX(100%) rotateY(90deg)}}@-webkit-keyframes rotateUnfoldTop{from{opacity:0;-webkit-transform:translateY(-100%) rotateX(90deg)}}@keyframes rotateUnfoldTop{from{opacity:0;-webkit-transform:translateY(-100%) rotateX(90deg);transform:translateY(-100%) rotateX(90deg)}}@-webkit-keyframes rotateUnfoldBottom{from{opacity:0;-webkit-transform:translateY(100%) rotateX(-90deg)}}@keyframes rotateUnfoldBottom{from{opacity:0;-webkit-transform:translateY(100%) rotateX(-90deg);transform:translateY(100%) rotateX(-90deg)}}@-webkit-keyframes rotateRoomLeftOut{to{opacity:.3;-webkit-transform:translateX(-100%) rotateY(90deg)}}@keyframes rotateRoomLeftOut{to{opacity:.3;-webkit-transform:translateX(-100%) rotateY(90deg);transform:translateX(-100%) rotateY(90deg)}}@-webkit-keyframes rotateRoomLeftIn{from{opacity:.3;-webkit-transform:translateX(100%) rotateY(-90deg)}}@keyframes rotateRoomLeftIn{from{opacity:.3;-webkit-transform:translateX(100%) rotateY(-90deg);transform:translateX(100%) rotateY(-90deg)}}@-webkit-keyframes rotateRoomRightOut{to{opacity:.3;-webkit-transform:translateX(100%) rotateY(-90deg)}}@keyframes rotateRoomRightOut{to{opacity:.3;-webkit-transform:translateX(100%) rotateY(-90deg);transform:translateX(100%) rotateY(-90deg)}}@-webkit-keyframes rotateRoomRightIn{from{opacity:.3;-webkit-transform:translateX(-100%) rotateY(90deg)}}@keyframes rotateRoomRightIn{from{opacity:.3;-webkit-transform:translateX(-100%) rotateY(90deg);transform:translateX(-100%) rotateY(90deg)}}@-webkit-keyframes rotateRoomTopOut{to{opacity:.3;-webkit-transform:translateY(-100%) rotateX(-90deg)}}@keyframes rotateRoomTopOut{to{opacity:.3;-webkit-transform:translateY(-100%) rotateX(-90deg);transform:translateY(-100%) rotateX(-90deg)}}@-webkit-keyframes rotateRoomTopIn{from{opacity:.3;-webkit-transform:translateY(100%) rotateX(90deg)}}@keyframes rotateRoomTopIn{from{opacity:.3;-webkit-transform:translateY(100%) rotateX(90deg);transform:translateY(100%) rotateX(90deg)}}@-webkit-keyframes rotateRoomBottomOut{to{opacity:.3;-webkit-transform:translateY(100%) rotateX(90deg)}}@keyframes rotateRoomBottomOut{to{opacity:.3;-webkit-transform:translateY(100%) rotateX(90deg);transform:translateY(100%) rotateX(90deg)}}@-webkit-keyframes rotateRoomBottomIn{from{opacity:.3;-webkit-transform:translateY(-100%) rotateX(-90deg)}}@keyframes rotateRoomBottomIn{from{opacity:.3;-webkit-transform:translateY(-100%) rotateX(-90deg);transform:translateY(-100%) rotateX(-90deg)}}@-webkit-keyframes rotateCubeLeftOut{50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateX(-50%) translateZ(-200px) rotateY(-45deg)}100%{opacity:.3;-webkit-transform:translateX(-100%) rotateY(-90deg)}}@keyframes rotateCubeLeftOut{50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateX(-50%) translateZ(-200px) rotateY(-45deg);transform:translateX(-50%) translateZ(-200px) rotateY(-45deg)}100%{opacity:.3;-webkit-transform:translateX(-100%) rotateY(-90deg);transform:translateX(-100%) rotateY(-90deg)}}@-webkit-keyframes rotateCubeLeftIn{0%{opacity:.3;-webkit-transform:translateX(100%) rotateY(90deg)}50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateX(50%) translateZ(-200px) rotateY(45deg)}}@keyframes rotateCubeLeftIn{0%{opacity:.3;-webkit-transform:translateX(100%) rotateY(90deg);transform:translateX(100%) rotateY(90deg)}50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateX(50%) translateZ(-200px) rotateY(45deg);transform:translateX(50%) translateZ(-200px) rotateY(45deg)}}@-webkit-keyframes rotateCubeRightOut{50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateX(50%) translateZ(-200px) rotateY(45deg)}100%{opacity:.3;-webkit-transform:translateX(100%) rotateY(90deg)}}@keyframes rotateCubeRightOut{50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateX(50%) translateZ(-200px) rotateY(45deg);transform:translateX(50%) translateZ(-200px) rotateY(45deg)}100%{opacity:.3;-webkit-transform:translateX(100%) rotateY(90deg);transform:translateX(100%) rotateY(90deg)}}@-webkit-keyframes rotateCubeRightIn{0%{opacity:.3;-webkit-transform:translateX(-100%) rotateY(-90deg)}50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateX(-50%) translateZ(-200px) rotateY(-45deg)}}@keyframes rotateCubeRightIn{0%{opacity:.3;-webkit-transform:translateX(-100%) rotateY(-90deg);transform:translateX(-100%) rotateY(-90deg)}50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateX(-50%) translateZ(-200px) rotateY(-45deg);transform:translateX(-50%) translateZ(-200px) rotateY(-45deg)}}@-webkit-keyframes rotateCubeTopOut{50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateY(-50%) translateZ(-200px) rotateX(45deg)}100%{opacity:.3;-webkit-transform:translateY(-100%) rotateX(90deg)}}@keyframes rotateCubeTopOut{50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateY(-50%) translateZ(-200px) rotateX(45deg);transform:translateY(-50%) translateZ(-200px) rotateX(45deg)}100%{opacity:.3;-webkit-transform:translateY(-100%) rotateX(90deg);transform:translateY(-100%) rotateX(90deg)}}@-webkit-keyframes rotateCubeTopIn{0%{opacity:.3;-webkit-transform:translateY(100%) rotateX(-90deg)}50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateY(50%) translateZ(-200px) rotateX(-45deg)}}@keyframes rotateCubeTopIn{0%{opacity:.3;-webkit-transform:translateY(100%) rotateX(-90deg);transform:translateY(100%) rotateX(-90deg)}50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateY(50%) translateZ(-200px) rotateX(-45deg);transform:translateY(50%) translateZ(-200px) rotateX(-45deg)}}@-webkit-keyframes rotateCubeBottomOut{50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateY(50%) translateZ(-200px) rotateX(-45deg)}100%{opacity:.3;-webkit-transform:translateY(100%) rotateX(-90deg)}}@keyframes rotateCubeBottomOut{50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateY(50%) translateZ(-200px) rotateX(-45deg);transform:translateY(50%) translateZ(-200px) rotateX(-45deg)}100%{opacity:.3;-webkit-transform:translateY(100%) rotateX(-90deg);transform:translateY(100%) rotateX(-90deg)}}@-webkit-keyframes rotateCubeBottomIn{0%{opacity:.3;-webkit-transform:translateY(-100%) rotateX(90deg)}50%{-webkit-animation-timing-function:ease-out;-webkit-transform:translateY(-50%) translateZ(-200px) rotateX(45deg)}}@keyframes rotateCubeBottomIn{0%{opacity:.3;-webkit-transform:translateY(-100%) rotateX(90deg);transform:translateY(-100%) rotateX(90deg)}50%{-webkit-animation-timing-function:ease-out;animation-timing-function:ease-out;-webkit-transform:translateY(-50%) translateZ(-200px) rotateX(45deg);transform:translateY(-50%) translateZ(-200px) rotateX(45deg)}}@-webkit-keyframes rotateCarouselLeftOut{to{opacity:.3;-webkit-transform:translateX(-150%) scale(0.4) rotateY(-65deg)}}@keyframes rotateCarouselLeftOut{to{opacity:.3;-webkit-transform:translateX(-150%) scale(0.4) rotateY(-65deg);transform:translateX(-150%) scale(0.4) rotateY(-65deg)}}@-webkit-keyframes rotateCarouselLeftIn{from{opacity:.3;-webkit-transform:translateX(200%) scale(0.4) rotateY(65deg)}}@keyframes rotateCarouselLeftIn{from{opacity:.3;-webkit-transform:translateX(200%) scale(0.4) rotateY(65deg);transform:translateX(200%) scale(0.4) rotateY(65deg)}}@-webkit-keyframes rotateCarouselRightOut{to{opacity:.3;-webkit-transform:translateX(200%) scale(0.4) rotateY(65deg)}}@keyframes rotateCarouselRightOut{to{opacity:.3;-webkit-transform:translateX(200%) scale(0.4) rotateY(65deg);transform:translateX(200%) scale(0.4) rotateY(65deg)}}@-webkit-keyframes rotateCarouselRightIn{from{opacity:.3;-webkit-transform:translateX(-200%) scale(0.4) rotateY(-65deg)}}@keyframes rotateCarouselRightIn{from{opacity:.3;-webkit-transform:translateX(-200%) scale(0.4) rotateY(-65deg);transform:translateX(-200%) scale(0.4) rotateY(-65deg)}}@-webkit-keyframes rotateCarouselTopOut{to{opacity:.3;-webkit-transform:translateY(-200%) scale(0.4) rotateX(65deg)}}@keyframes rotateCarouselTopOut{to{opacity:.3;-webkit-transform:translateY(-200%) scale(0.4) rotateX(65deg);transform:translateY(-200%) scale(0.4) rotateX(65deg)}}@-webkit-keyframes rotateCarouselTopIn{from{opacity:.3;-webkit-transform:translateY(200%) scale(0.4) rotateX(-65deg)}}@keyframes rotateCarouselTopIn{from{opacity:.3;-webkit-transform:translateY(200%) scale(0.4) rotateX(-65deg);transform:translateY(200%) scale(0.4) rotateX(-65deg)}}@-webkit-keyframes rotateCarouselBottomOut{to{opacity:.3;-webkit-transform:translateY(200%) scale(0.4) rotateX(-65deg)}}@keyframes rotateCarouselBottomOut{to{opacity:.3;-webkit-transform:translateY(200%) scale(0.4) rotateX(-65deg);transform:translateY(200%) scale(0.4) rotateX(-65deg)}}@-webkit-keyframes rotateCarouselBottomIn{from{opacity:.3;-webkit-transform:translateY(-200%) scale(0.4) rotateX(65deg)}}@keyframes rotateCarouselBottomIn{from{opacity:.3;-webkit-transform:translateY(-200%) scale(0.4) rotateX(65deg);transform:translateY(-200%) scale(0.4) rotateX(65deg)}}@-webkit-keyframes rotateSidesOut{to{opacity:0;-webkit-transform:translateZ(-500px) rotateY(90deg)}}@keyframes rotateSidesOut{to{opacity:0;-webkit-transform:translateZ(-500px) rotateY(90deg);transform:translateZ(-500px) rotateY(90deg)}}@-webkit-keyframes rotateSidesIn{from{opacity:0;-webkit-transform:translateZ(-500px) rotateY(-90deg)}}@keyframes rotateSidesIn{from{opacity:0;-webkit-transform:translateZ(-500px) rotateY(-90deg);transform:translateZ(-500px) rotateY(-90deg)}}@-webkit-keyframes rotateSlideOut{25%{opacity:.5;-webkit-transform:translateZ(-500px)}75%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(-200%)}100%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(-200%)}}@keyframes rotateSlideOut{25%{opacity:.5;-webkit-transform:translateZ(-500px);transform:translateZ(-500px)}75%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(-200%);transform:translateZ(-500px) translateX(-200%)}100%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(-200%);transform:translateZ(-500px) translateX(-200%)}}@-webkit-keyframes rotateSlideIn{0%, 25%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(200%)}75%{opacity:.5;-webkit-transform:translateZ(-500px)}100%{opacity:1;-webkit-transform:translateZ(0) translateX(0)}}@keyframes rotateSlideIn{0%, 25%{opacity:.5;-webkit-transform:translateZ(-500px) translateX(200%);transform:translateZ(-500px) translateX(200%)}75%{opacity:.5;-webkit-transform:translateZ(-500px);transform:translateZ(-500px)}100%{opacity:1;-webkit-transform:translateZ(0) translateX(0);transform:translateZ(0) translateX(0)}}.pt-page-delay100{-webkit-animation-delay:.1s;animation-delay:.1s}.pt-page-delay180{-webkit-animation-delay:.180s;animation-delay:.180s}.pt-page-delay200{-webkit-animation-delay:.2s;animation-delay:.2s}.pt-page-delay300{-webkit-animation-delay:.3s;animation-delay:.3s}.pt-page-delay400{-webkit-animation-delay:.4s;animation-delay:.4s}.pt-page-delay500{-webkit-animation-delay:.5s;animation-delay:.5s}.pt-page-delay700{-webkit-animation-delay:.7s;animation-delay:.7s}.pt-page-delay1000{-webkit-animation-delay:1s;animation-delay:1s}

html,body{margin:0;overflow-x:hidden}.campaign-list-table{display:none}.aui #app .btn:active,.aui #app .field-input-button:active{top:auto !important}.aui #app select{height:50px}.aui #app select{min-width:320px}.aui #app form .form-group{margin:10px 0}.aui #app form .form-group .form-control{padding:14px 10px;border-radius:5px;min-width:300px}#app{height:750px}#app .app-messaging{color:#FFF;position:fixed;padding:10px;top:0;width:100%;z-index:100}#app .steps-container{position:relative;width:100%;height:100%;perspective:1200px;transform-style:preserve-3d}#app .steps-container .page{width:100%;height:100%;position:absolute;top:0;left:0;visibility:hidden;overflow:hidden;backface-visibility:hidden;transform:translate3d(0, 0, 0);display:flex;align-items:center;padding:50px;box-sizing:border-box}#app .steps-container .page .centered{width:100%}#app .steps-container .page.step1 .file-info{text-align:center;margin:10px 0}#app .steps-container .page.step2{background:#E6E6E6}#app .steps-container .page-current{visibility:visible}#app .steps-container .pt-page-ontop{z-index:999}#app .steps-container .progress-bar-container{margin:40px 0;height:40px;position:relative;width:90%;background:#eee;border-radius:2em}#app .steps-container .progress-bar{background:#f0a3a3;height:100%;position:absolute;box-sizing:border-box;border-radius:2em;transition:all .4s ease-in-out}#app .steps-container .progress-bar.complete{background:#92C969}#app .steps-container .progress-bar .percentage{position:absolute;right:3%;top:30%;color:#fff}#app .steps-container .progress-bar-description{position:absolute;display:block;left:5px;top:-25px}#app .progress-information-container{margin:20px 0;display:flex;width:100%;justify-content:space-between}#app .progress-information-container .info{text-align:center;width:45%}#app .progress-information-container .info span{display:block}#app .progress-information-container .info span.desc{text-transform:uppercase;font-weight:bold;font-size:11px;letter-spacing:1px}#app .progress-information-container .info span.value{font-size:5em;line-height:1em;color:#ccc;letter-spacing:0;font-weight:lighter}#app .steps-navigation{position:absolute;bottom:0;width:100%;height:100px}#app .steps-navigation button{position:absolute}#app .steps-navigation button.next{bottom:15%;right:5%}#app .steps-navigation button.prev{bottom:15%;left:5%}#app .file-drag{font-weight:bold;align-items:center;padding:4.5em 0;margin:2em auto;background:#F5F5F5;cursor:default;transition:all .5s ease-in-out}#app .file-drag .icons-container{display:block;margin:auto;position:relative;height:200px;width:150px}#app .file-drag .icons-container article{position:absolute;text-align:center}#app .file-drag .icons-container .upload-icon-container{transition:all .25s ease-in-out}#app .file-drag .icons-container .upload-icon-container svg{display:block;margin:auto;transform:scale(2);height:200px;width:124px}#app .file-drag .icons-container .check-icon-container{opacity:0;transition:all .25s ease-in-out}#app .file-drag .icons-container .check-icon-container svg{transform:scale(1.5);height:200px}#app .file-drag .icons-container .error-icon-container{opacity:0}#app .file-drag .icons-container .error-icon-container svg{transform:scale(1.3);height:180px;width:130px}#app .file-drag .file-drop-text{margin:auto;text-align:center}#app .file-drag.hover{background:#4C90EC;box-shadow:inset 0 3px 4px #888;transition:all .5s ease-in-out;cursor:pointer}.aui .block-container{padding:0}

.aui #app .btn:active,.aui #app .field-input-button:active{top:auto !important}.aui #app select{height:50px}.aui #app select{min-width:320px}.aui #app form .form-group{margin:10px 0}.aui #app form .form-group .form-control{padding:14px 10px;border-radius:5px;min-width:300px}
;
</style>

<table class="campaign-list-table">
	<tr>
		<th>Campaign Name</th>
		<th>Campaign ID</th>
	</tr>
	#foreach ($record in $records)
	<tr>
		<td>$record.getFieldValue("campaign_name")</td>
		<td>$record.getFieldValue("campaign_id")</td>
	</tr>
	#end
</table>

<div id="app">
	<div class="app-messaging"></div>
	<div class="steps-container"></div>

	<div class="steps-navigation">
		<button class="prev btn">Previous</button>
		<button class="next btn">Next</button>
	</div>
</div>

<script>
	var config = (
	function() {
		return {
			cycle_duration: 1500,
			hubspotFormID: '231dd439-b782-4e95-9cee-776e9a29d3f2',
			hubspotPortalID: '252686',
			stepsContainerClass: 'steps-container',
			uploadContainerClass: 'file-drag',
			updateConfig: function(key, value) {
				this[key] = value;
			}
		};
	}
)();

var module = {};
var data = (
	function() {

		// our step prototype
		var stepObject = {
			// individual data received from each step
			step: 0,
			// determines whether user has completed the requirements of step
			completed: false,
			// functions to run when user completes
			onComplete: undefined,
			// function to run when a step is in view
			onLoad: undefined
		};

		return {
			allSteps: [],
			campaign: undefined,

			// creates new step object
			completeStep: function(step) {
				var currentStep = this.allSteps[step - 1];

				currentStep.completed = true;
				if (currentStep.onComplete) {
					currentStep.onComplete();
				}
			},
			createStep: function(config) {
				var currentStep = Object.create(stepObject);

				this.numberOfSteps++;

				// create our step object
				currentStep.step = this.numberOfSteps;
				currentStep.html = config.html || currentStep.html;
				currentStep.completed = config.completed || currentStep.completed;
				currentStep.onComplete = config.onComplete || currentStep.onComplete;
				currentStep.onLoad = config.onLoad || currentStep.onLoad;

				// push it to master object
				this.allSteps.push(currentStep);

				// render HTML
				this.renderStep(this.numberOfSteps);

				return currentStep;
			},
			incompleteStep: function(step) {
				var currentStep = this.allSteps[step - 1];

				currentStep.completed = false;
			},
			json: undefined,
			loadStep: function(step) {
				var currentStep = this.allSteps[step - 1];

				if (currentStep.onLoad) {
					currentStep.onLoad();
				}
			},
			numberOfSteps: 0,
			renderStep: function(step) {
				core.templateRender(core.config.stepsContainerClass, this.allSteps[step - 1].html);
			},
			state: {
				navigation: 'begin'
			},
			updateData: function(key, value) {
				this[key] = value;
			}
		};
	}
)();
var ui = (
	function() {

		var nextBtn = document.querySelector('.steps-navigation .next');
		var prevBtn = document.querySelector('.steps-navigation .prev');
		var messageContainer = document.querySelector('.app-messaging');

		// controls navigation controls
		var navigate = (
			function() {
				var currentPage = 0;

				var movePage = function(direction) {
					var animating = false;
					var animationDuration = 700;
					var pages = document.querySelectorAll('.page');

					// don't move if page is currently animating and if reached end/beginning
					if (animating || ((direction === 'back') && currentPage === 0) || ((direction === 'forward') && currentPage + 1 === pages.length)) {
						return false;
					}

					animating = true;

					var enterAnimationClass = 'pt-page-movefromRightFade';
					var exitAnimation = 'pt-page-moveToLeftFade';
					var nextPage = pages[currentPage + 1];
					var thisPage = pages[currentPage];

					if (direction === 'back') {
						enterAnimationClass = 'pt-page-moveFromLeftFade';
						exitAnimation = 'pt-page-moveToRightFade';
						nextPage = pages[currentPage - 1];
					}

					thisPage.classList.add(exitAnimation);
					nextPage.classList.add(enterAnimationClass);
					nextPage.classList.add('page-current');

					thisPage.classList.remove('page-current');

					setTimeout(
						function() {
							nextPage.classList.remove(enterAnimationClass);
							thisPage.classList.remove(exitAnimation);

							animating = false;
						},
						animationDuration
					);

					if (direction === 'back') {
						currentPage--;
					}
					else {
						currentPage++;
					}

					// lastly tell application that page has been moved
					core.publisher.fire('pageMoved', currentPage + 1);
				};

				prevBtn.addEventListener(
					'click',
					function() {
						movePage('back');
					}
				);

				nextBtn.addEventListener(
					'click',
					function() {
						movePage('forward');
					}
				);
			}
		)();

		var changeNavigationState = function(state) {
			if (state === 'begin') {
				prevBtn.style.display = 'none';
				nextBtn.style.display = 'block';
			}

			else if (state === 'block') {
				prevBtn.style.display = 'none';
				nextBtn.style.display = 'none';
			}

			else if (state === 'proceed') {
				prevBtn.style.display = 'block';
				nextBtn.style.display = 'block';
			}

			else {
				prevBtn.style.display = 'block';
				nextBtn.style.display = 'none';
			}
		};

		var newMessage = function(message, type, action, callback) {
			// change message
			messageContainer.style.display = "block";
			messageContainer.innerHTML = message;

			if (type === "error") {
				messageContainer.style.backgroundColor = "#cc0000";
			}

			// if a message is set to timer
			var timerMessage = function() {
				setTimeout(function() {
					messageContainer.style.display = "none";
					if (callback) {
						callback()
					};
				}, 5000)
			}

			if (action === "flash") {
				timerMessage();
			}
		};

		var closeMessage = function() {
			messageContainer.style.display = "none";
		}

		return {
			changeNavigationState: changeNavigationState,
			newMessage: newMessage,
			closeMessage: closeMessage
		};

	}
)();
var core = (
	function() {

		// renders HTML onto a template
		var templateRender = function(parentClass, view) {
			var container = document.querySelector('.' + parentClass);

			container.insertAdjacentHTML('beforeend', view);
		};

		// our application observer
		var publisher = {
			fire: function(type, publication) {
				this.visitSubscribers('publish', type, publication);
			},
			on: function(type, fn, context) {
				fn = typeof fn === 'function' ? fn : context[fn];
				type = type || 'any';

				if (typeof this.subscribers[type] === 'undefined') {
					this.subscribers[type] = [];
				}

				this.subscribers[type].push(
					{
						context: context || this,
						fn: fn
					}
				);
			},
			remove: function(type, fn, context) {
				this.visitSubscribers('unsubscribe', type, fn, context);
			},
			subscribers: {
				any: []
			},
			visitSubscribers: function(action, type, arg, context) {
				var pubtype = type || 'any';
				var subscribers = this.subscribers[pubtype];

				var max = subscribers ? subscribers.length : 0;

				for (var i = 0; i < max; i += 1) {
					if (action === 'publish') {
						// Call our observers, passing along arguments
						subscribers[i].fn.call(subscribers[i].context, arg);
					}
					else if (subscribers[i].fn === arg && subscribers[i].context === context) {
						subscribers.splice(i, 1);
					}
				}
			}
		};

		// allows for multiple steps and multiple tests for each step.
		var processAndTest = function(initialData) {
			var self = this;
			this.processSets = [];
			this.data = initialData;
			this.errorMessage = undefined;
			this.pass = false;
			this.newProcess = function(options) {
				self.processSets.push({
					action: options.action,
					tests: options.tests,
					mode: options.mode,
					errorMessage: options.errorMessage
				})
			};
			this.run = function() {
				var counter = 0;
				var numOfProcess = self.processSets.length;
				var currentSet = self.processSets[counter];

				// supports async operations
				var runNextAction = function(set) {
					// if async
					if (currentSet.mode == "async") {
						currentSet.action(self.data)
							.then(function(res) {
								self.data = res;
								runTests(currentSet);
							})
					}
					// if sync
					else {
						self.data = currentSet.action(self.data);
						runTests(currentSet);
					}
				};

				// only sync operations
				var runTests = function(data) {

					// if it fails test
					if (self.runTests(data) === false) {
						self.pass = false;
						self.onEnd();
					}
					// if current set passes test
					else {
						runItAgain();
					}
				}

				// our loop/counter
				var runItAgain = function() {
					// should we run the next one?
					if ((counter + 1) < numOfProcess) {
						counter++
						currentSet = self.processSets[counter];
						runNextAction(currentSet);
					}

					else {
						self.pass = true;
						self.onEnd()
					}
				}

				// run it for the first time.
				runNextAction(currentSet);
			};
			this.onEnd = function() {},
			this.runTests = function(set) {
				for (var i = 0; i < set.tests.length ; i++) {
					var testResult = set.tests[i](self.data);

					if (testResult !== true) {
						self.errorMessage = testResult;
						return false;
					}
				}
			};
		};

		// use this to change state of application
		var changeState = function(stateName, state) {
			data['state'][stateName] = state;
			publisher.fire('stateChange', state);
		};

		// internally registering handling of
		publisher.on('stateChange', ui.changeNavigationState);

		return {
			// other modules
			config: config,
			data: data,
			ui: ui,

			// utility functions
			changeState: changeState,
			publisher: publisher,
			processAndTest: processAndTest,
			templateRender: templateRender
		};

	}
)(data, config, ui);
(function() {
    Array.prototype.CSSClassIndexOf = Array.prototype.indexOf || function(item) {
        var length = this.length;
        for (var i = 0; i < length; i++)
            if (this[i] === item) return i;
        return -1;
    };
    var cl = ("classList" in document.createElement("a"));
    var p = Element.prototype;
    
    if (cl) {
        if (!p.hasClass)
            p.hasClass = function(c) {
                var e = Array.prototype.slice.call(this.classList);
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (!this.classList.contains(c[i]))
                        return false;
                return true;
            };
        if (!p.addClass)
            p.addClass = function(c) {
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (!this.hasClass(c[i]))
                        this.classList.add(c[i]);
                return this;
            };
        if (!p.removeClass)
            p.removeClass = function(c) {
                var e = this.className.split(' ');
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (this.hasClass(c[i]))
                        this.classList.remove(c[i]);
                return this;
            };
        if (!p.toggleClass)
            p.toggleClass = function(c) {
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    this.classList.toggle(c[i]);
                return this;
            };
    } else {
        if (!p.hasClass)
            p.hasClass = function(c) {
                var e = this.className.split(' ');
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (e.CSSClassIndexOf(c[i]) === -1)
                        return false;
                return true;
            };
        if (!p.addClass)
            p.addClass = function(c) {
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (!this.hasClass(c[i]))
                        this.className = this.className !== '' ? (this.className + ' ' + c[i]) : c[i];
                return this;
            };
        if (!p.removeClass)
            p.removeClass = function(c) {
                var e = this.className.split(' ');
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (this.hasClass(c[i]))
                        e.splice(e.CSSClassIndexOf(c[i]), 1);
                this.className = e.join(' ');
                return this;
            };
        if (!p.toggleClass)
            p.toggleClass = function(c) {
                c = c.split(' ');
                for (var i = 0; i < c.length; i++)
                    if (this.hasClass(c[i]))
                        this.removeClass(c[i]);
                    else
                        this.addClass(c[i]);
                return this;
            };
    }
    var pl = NodeList.prototype;
    if (!pl.hasClass)
        pl.hasClass = function(c, all) {
            if (all === undefined) all = true;
            for (var i = this.length - 1; i >= 0; --i) {
                var hc = this[i].hasClass(c);
                if (all && !hc) return false;
                if (!all && hc) return true;
            }
            return true;
        };
    if (!pl.addClass)
        pl.addClass = function(c) {
            for (var i = 0; i < this.length; ++i)
                this[i].addClass(c);
        };
    if (!pl.removeClass)
        pl.removeClass = function(c) {
            for (var i = 0; i < this.length; ++i)
                this[i].removeClass(c);
        };
    if (!pl.toggleClass)
        pl.toggleClass = function(c) {
            for (var i = 0; i < this.length; ++i)
                this[i].toggleClass(c);
        };
})();

// module with functionalities for handling CSV's
var CSV = (function() {

	/*
		Turning CSV to JSON is multi-stepped needing multiple tests.
	 	We leverage the processAndTest util to accomplish this.
	*/
	var csvToJSON = function(csv) {

		var csvJSONtests = new core.processAndTest(csv);

		// step 1: check if it is a CSV file
		csvJSONtests.newProcess({
			action: function(data) {
				return data;
			},
			tests: [
				isItCSV
			]
		});

		// step 2: let browser read the file as string and test formatting
		csvJSONtests.newProcess({
			action: readFile,
			mode: "async",
			tests: [
				checkSpecialCharacters,
				emptyCSVFields
			]
		});

		// step 3 (incomplete): turn string into JSON
		csvJSONtests.newProcess({
			action: csvStringtoJSON,
			tests: [
				checkValidDate
			]
		});

		return csvJSONtests;
	};

	var isItCSV = function(file) {
		var fileMatches = 0;
		var acceptableFileTypes = [
			"text/csv",
			"application/vnd.ms-excel"
		];

		// test acceptable file types
		for (var p = 0; p < acceptableFileTypes.length; p++) {
			if (file.type == acceptableFileTypes[p]) {
				fileMatches++;
			}
		}

		if (fileMatches > 0) {
			return true;
		} else {
			return "Not a CSV File. File is " + file.type;
		}
	};

	var checkSpecialCharacters = function(csv) {
		var csvArray = csv.split('\n');
		var pattern = new RegExp(/[~`!#$%\^&*=\\[\]\\;{}|\\"<>\?]/);

		for (let i = 0; i < csvArray.length; i++) {
			if (csvArray[i].match(pattern)) {
				let matchArray = csvArray[i].match(pattern);
				
				return 'Special character ' + matchArray[0] + ' found on Line ' + (i + 1) + ' Column ' + matchArray.index;
			}
		}

		return true;
	};

	var emptyCSVFields = function(csv) {
		var emptyPattern = new RegExp(",,");
		var res = emptyPattern.test(csv);

		if (res) {
			return "CSV File Missing Entries";
		}
		else {
			return true;
		}
	};

	var checkValidDate = function(json) {
		var errorMessage = "";
		var errors = 0;
		var datePattern = new RegExp(/[/]/);

		for (var g = 0; g < json.length; g++) {
			var date = json[g]["Interaction Date"];

			if (datePattern.test(date)) {
				errors++;
				errorMessage += "Date improperly formatted on line " + (g + 2) + "<br />";
			}
		}

		if (errors !== 0) {
			return errorMessage;
		}
		else {
			return true;
		}
	};

	// convert csv to JSON object
	var csvStringtoJSON = function(csv) {
		var lines = csv.split('\n');
		var result = [];

		var headers = lines[0].split(',');

		for (var i = 1; i < lines.length; i++) {
			var currentline = lines[i].split(',');
			var obj = {};

			for (var j = 0; j < headers.length; j++) {
				var currentHeader = headers[j];
				var currentLine = currentline[j];

				// data integrity by removing special characters
				currentHeader = currentHeader.replace(/[^a-zA-Z ]/g, "");
				obj[currentHeader] = currentLine;
			}

			result.push(obj);
		}

		return result;
	};

	// read file in browser
	var readFile = function(file) {
		return new Promise(function(resolve, reject) {
			var reader = new FileReader();
			var content = reader.readAsText(file);

			reader.onload = function() {
				resolve(reader.result);
			};
		});

	};

	return {
		csvToJSON: csvToJSON
	};

})();
var hubspot = (function() {
	var hubspotFormID = config.hubspotFormID || '';
	var hubspotPortalID = config.hubspotPortalID || '';

	var sendToHubspot = function(url, paramObj) {
		var ajax = new XMLHttpRequest();
		var queryParameters = "";
		var counter = 0;

		if (paramObj) {
			console.log(paramObj);

			for (var key in paramObj) {
				if (paramObj.hasOwnProperty(key)) {
					let firstParameterPrefix = "&";

					if (counter == 0) {
						firstParameterPrefix = "?";
					}

					counter++;
					queryParameters = queryParameters + firstParameterPrefix + key + "=" + paramObj[key];
				}
			}
		}

		ajax.open(
			'POST',
			url + '/' + hubspotPortalID + '/' + hubspotFormID + queryParameters
		);

		ajax.send();
	};

	return {
		sendToHubspot: sendToHubspot
	};

})(config);
var UTILS = (function() {
    // Converts an HTML table to JS object
    var tableToJson = function(table) {
        var data = [];

        var headers = [];
        for (var i = 0; i < table.rows[0].cells.length; i++) {
            headers[i] = table.rows[0].cells[i].innerHTML.toLowerCase().replace(/ /gi, '');
        }

        for (var i = 1; i < table.rows.length; i++) {
            var tableRow = table.rows[i];
            var rowData = {};

            for (var j = 0; j < tableRow.cells.length; j++) {
                rowData[headers[j]] = tableRow.cells[j].innerHTML;
            }

            data.push(rowData);
        }

        return data;
    };

    return {
        tableToJson: tableToJson
    };
})();

'use strict';
step1view = Object.create(null);
step1view['view.html'] = '<div class="page step1 page-current" data-step="1">\n	<div class="centered">\n		<h1>Marketing Interactions Import Tool</h1>\n		<p>Marketing interaction data describes who did what and when, in instances where this data isn\'t natively tracked by HubSpot. Take for example a list of industry event booth scans: the data in the list describes who was scanned at the industry event, and when they were scanned.</p>\n		<p>This tool makes it easy to take the Marketing interaction data in whatever format it exists and record it in HubSpot where it can be blended with our other touchpoint data.</p>\n		\n		<p><strong>Step 1:</strong> Use the <a href="https://docs.google.com/a/liferay.com/spreadsheets/d/1Blb9yvoaaZFR8Az2PnZflC1hHvC5DTpz1BhF8vXrsak/edit?usp=sharing" target="_blank">HubSpot List and Interaction Import Worksheet</a> to generate two files: a list to upload directly to HubSpot and a list to upload here.</p>\n		\n		<p><strong>Step 2:</strong> <a href="https://app.hubspot.com/contacts/252686/import/" target="_blank">Upload the HubSpot List to HubSpot first</a>. Then return to this page.</p>\n		\n		<p><strong>Step 3:</strong> Upload the Interactions list below.</p>\n\n		<div class="file-drag">\n			<div class="icons-container">\n				<article class="upload-icon-container">\n					<svg height="32" viewBox="0 0 32 32" width="32" xmlns="http://www.w3.org/2000/svg"><title/><path d="M16 16l-3.25 3.25-.75-.75 4.5-4.5 4.5 4.5-.75.75L17 16v11h-1V16zm-1 5H8.003C5.798 21 4 19.21 4 17c0-1.895 1.325-3.488 3.1-3.898-.065-.357-.1-.726-.1-1.102 0-3.314 2.686-6 6-6 2.615 0 4.84 1.673 5.66 4.008C19.437 9.378 20.425 9 21.5 9c2.358 0 4.293 1.814 4.484 4.123C27.714 13.563 29 15.133 29 17c0 2.205-1.792 4-4.003 4H18v1h7c2.762 0 5-2.244 5-5 0-2.096-1.287-3.89-3.117-4.634C26.36 9.872 24.15 8 21.5 8c-.863 0-1.68.2-2.406.553C17.89 6.43 15.614 5 13 5c-3.866 0-7 3.134-7 7 0 .138.004.275.012.412C4.24 13.182 3 14.95 3 17c0 2.76 2.232 5 5 5h7v-1z" fill="#333" fill-rule="evenodd"/></svg>\n				</article>\n				<article class="check-icon-container">\n					<svg height="128" viewBox="0 0 128 128" width="128" xmlns="http://www.w3.org/2000/svg"><path d="M85.263 46.49L54.485 77.267l-11.68-11.683c-.782-.782-2.048-.782-2.83-.002-.78.782-.78 2.048 0 2.83l14.51 14.512 33.606-33.607c.782-.78.782-2.046 0-2.827-.78-.782-2.046-.782-2.827 0zm-21.23-32.62c-27.643 0-50.13 22.49-50.13 50.127.002 27.642 22.49 50.13 50.13 50.13h.005c27.638 0 50.123-22.488 50.123-50.13 0-27.64-22.486-50.126-50.128-50.126zm.005 96.258h-.004c-25.435 0-46.13-20.694-46.13-46.13 0-25.435 20.692-46.127 46.128-46.127s46.13 20.694 46.13 46.127c0 25.437-20.69 46.13-46.124 46.13z"/></svg>\n				</article>\n				<article class="error-icon-container">\n					<svg height="512" viewBox="0 0 512 512" width="512" xmlns="http://www.w3.org/2000/svg"><path d="M256 7C118.467 7 7 118.468 7 256.002 7 393.532 118.467 505 256 505s249-111.467 249-248.998C505 118.468 393.533 7 256 7zm0 478.08c-126.31 0-229.08-102.77-229.08-229.078C26.92 129.692 129.69 26.92 256 26.92c126.31 0 229.08 102.77 229.08 229.082C485.08 382.31 382.31 485.08 256 485.08z" fill="#f33"/><path fill="#f33" d="M368.545 157.073l-14.084-14.085-98.597 98.6-98.13-98.132-14.085 14.084 98.132 98.132-98.132 98.137 14.085 14.083 98.13-98.143 98.598 98.61 14.085-14.085-98.598-98.603"/></svg>\n				</article>\n			</div>\n			<div class="file-drop-text">Drop CSV Files Here!</div>\n		</div>\n		<div class="file-info"></div>\n	</div>\n</div>';

'use strict';
step2view = Object.create(null);
step2view['view.html'] = '<div class="page step2" data-step="2">\n	<div class="centered">\n		<p><strong>Step 4 (Optional): </strong>. Were the interactions your list describes tied to a Salesforce campaign? If so, select a campaign from the list below. If not, leave this field blank and continue.</p>\n		<p>Need to create a Salesforce campaign? <a href="mailto:karena.kenmotsu@liferay.com">Contact Karena</a></p>\n		<form>\n			<div class="form-group">\n				<label>Campaign</label>	\n				<select class="campaign-list-dropdown">\n					\n				</select>\n			</div>\n		</form>\n		\n	</div>\n</div>';

'use strict';
step3view = Object.create(null);
step3view['view.html'] = '<div class="page step3" data-step="3">\n	<div class="centered">\n			<h1>Just a minute...</h1>\n			<p class="page-description">We\'re uploading your data to Hubspot!</p>\n			\n\n			<div class="progress-bar-container">\n				<span class="progress-bar-description">Sample description</span>\n				<div class="progress-bar">\n					<span class="percentage"></span>\n				</div>\n			</div>\n\n			<div class="progress-information-container">\n				<div class="info entries-left">\n					<span class="desc">Entries Left</span>\n					<span class="value"></span>\n				</div>\n				<div class="info time-left">\n					<span class="desc">Estimated Time Left</span>\n					<span class="value"></span>\n				</div>\n			</div>\n	</div>\n</div>';

var steps = (function() {

	var completeStep = function(step) {
		data.completeStep(step);
	};

	var initStep = function(config) {
		data.createStep(config);
	};

	// listen for when the page moves
	core.publisher.on('pageMoved', data.loadStep, data);

	return {
		completeStep: completeStep,
		initStep: initStep
	};

})(core);
var step1 = (function() {

	steps.initStep(
		{
			html: step1view['view.html'],
			onComplete: function() {
				core.changeState('navigation', 'begin');
			}
		}
	);

	var controller = (function() {
		var processFile = function(file) {
			var processer = CSV.csvToJSON(file);

			processer.onEnd = function() {
				if (processer.pass === true) {
					steps.completeStep(1);
					UI.fileGrade('pass');
					data.updateData('json', processer.data);
				}

				else {
					UI.fileGrade('fail', processer.errorMessage);
				}
			};

			processer.run();
		};

		return {
			processFile: processFile
		};
	})();

	var UI = (function() {
		var checkSVGContainer = document.querySelector('.check-icon-container');
		var dropContainerText = document.querySelector('.file-drop-text');
		var errorSVGContainer = document.querySelector('.error-icon-container');
		var fileInfoContainer = document.querySelector('.file-info');
		var uploadSVGContainer = document.querySelector('.upload-icon-container');

		// controls drag and upload UI
		var fileDrop = (function() {
			var filedrag = document.querySelector('.file-drag');

			function fileDragHover(e) {
				e.stopPropagation();
				e.preventDefault();
				filedrag.className = (e.type == 'dragover') ? 'file-drag hover' : 'file-drag';
			}

			function fileSelectHandler(e) {
				fileDragHover(e);
				var files = e.dataTransfer.files;

				controller.processFile(files[0]);
				fileChanged(files[0].name);
			}

			filedrag.addEventListener(
				'dragover',
				function(e) {
					fileDragHover(e);
				},
				false
			);

			filedrag.addEventListener(
				'dragleave',
				function(e) {
					fileDragHover(e);
				},
				false
			);

			filedrag.addEventListener(
				'drop',
				function(e) {
					fileSelectHandler(e);
				},
				false
			);

		})();

		var fileChanged = function(text) {
			dropContainerText.innerHTML = text;
		};

		var fileGrade = function(result, message) {
			if (result === 'fail') {
				uploadSVGContainer.style.opacity = 0;
				checkSVGContainer.style.opacity = 0;
				errorSVGContainer.style.opacity = 1;
				ui.newMessage(message, "error");
			}
			else {
				uploadSVGContainer.style.opacity = 0;
				checkSVGContainer.style.opacity = 1;
				errorSVGContainer.style.opacity = 0;
				ui.closeMessage();
			}
		};

		return {
			fileChanged: fileChanged,
			fileGrade: fileGrade
		};
	})(controller);
})(CSV, hubspot, steps);
var step2 = (
	function() {
		steps.initStep(
			{
				html: step2view['view.html'],
				onComplete: function() {
					core.ui.changeNavigationState('begin');
				},
				onLoad: function() {
					core.ui.changeNavigationState('block');
					ui.renderDropdown();
					steps.completeStep(2);
				}
			}
		);

		// UI for our step
		var ui = (
			function() {

				// controls when form changes
				var form = (
					function() {
						var campaignDropDown = document.querySelector('.campaign-list-dropdown');
						var formID = document.querySelector('#form-id');
						var interactionType = document.querySelector('#interaction-type');

						campaignDropDown.addEventListener(
							'change',
							function(e) {
								core.data.updateData('campaign', campaignDropDown.options[campaignDropDown.selectedIndex].value);
							},
							false
						);
					}
				)();

			// render our dropdown list
			var renderDropdown = function() {
				var campaignListTable = document.querySelector('.campaign-list-table');
				var campaignData = UTILS.tableToJson(campaignListTable);
				var campaignListDropdown = document.querySelector('.campaign-list-dropdown');
				var dropdownHTML = "";

				for (var p = 0; p < campaignData.length + 1; p++) {
					if (p == 0) {
						dropdownHTML = '<option selected="true" value="">No Campaign</option>';
					} else {
						dropdownHTML += '<option value="' + campaignData[p - 1]["campaignid"] + '">' + campaignData[p - 1]["campaignname"] + '</option>';	
					}
				}

				campaignListDropdown.innerHTML = dropdownHTML;
			}

			return {
				renderDropdown: renderDropdown
			}
		}
	)();
	}
)(steps);
var step3 = (function() {

	steps.initStep(
		{
			html: step3view['view.html'],
			onComplete: function() {
				ui.doneUploading();
			},
			onLoad: function() {
				core.ui.changeNavigationState('block');
				util.initUploader();
				setTimeout(
					function() {
						util.startUpload();
					},
					500
				);
			}
		}
	);

	var util = (
		function() {

			var initUploader = function() {
				var entries = data.json;
				var noOfEntries = entries.length;

				ui.updateProgress(entries[0], -1, noOfEntries);
			};

			var startUpload = function() {
				var entries = data.json;
				var i = 0;
				var noOfEntries = entries.length;

				// our recursive timer for loop
				function timer() {
					setTimeout(
						function() {
							var entry = entries[i];

							hubspot.sendToHubspot('https://forms.hubspot.com/uploads/form/v2', {
								email: entry["Email Address"],
								hs_context: encodeURIComponent(JSON.stringify({
									sfdcCampaignId: data.campaign,
									"ipAddress": ""
								})),
								recent_interaction: entry["Interaction"],
								recent_interaction_detail: entry["Interaction Detail"],
								recent_interaction_date: entry["Interaction Date"],
								recent_interaction_type: entry["Interaction Type"],
								recent_interaction_campaign: data.campaign,
								lifecyclestage: 'Subscriber'
							});

							// 2) update UI
							ui.updateProgress(entries[i], i, noOfEntries);

							if (i < noOfEntries - 1) {
								timer();
								i++;
							}

							else if (i === noOfEntries - 1) {
								steps.completeStep(3);
							}
						},
						config.cycle_duration
					);
				}

				timer();
			};

			return {
				initUploader: initUploader,
				startUpload: startUpload
			};
		}
	)();

	var ui = (function() {
		var entriesLeftDescription = document.querySelector('.entries-left > .value');
		var pageSubitle = document.querySelector('.step3 .page-description');
		var pageTitle = document.querySelector('.step3 h1');
		var progressBar = document.querySelector('.progress-bar');
		var progressBarDescription = document.querySelector('.progress-bar-description');
		var progressBarPercentage = document.querySelector('.progress-bar > .percentage');
		var timeleftDescription = document.querySelector('.time-left > .value');

		// higher function to update all the different UI
		var updateProgress = function(entry, current, total) {
			// update percentage bar
			updateBar(current + 1, total);

			// update progress info
			updateProgressInfo(entry, current + 1, total);
		};

		var updateBar = function(current, total) {
			var percentage = (current / total) * 100;

			progressBar.style.width = percentage + '%';
			progressBarPercentage.innerHTML = Math.round(percentage) + '%';

			if (current === total) {
				progressBar.style.width = '100%';
			}
		};

		function startTimer(duration, display) {
			var diff;
			var minutes;
			var seconds;
			var start = Date.now();

			function timer() {

				// get the number of seconds that have elapsed since
				// startTimer() was called
				diff = duration - (((Date.now() - start) / 1000) | 0);

				// does the same job as parseInt truncates the float
				minutes = (diff / 60) | 0;
				seconds = (diff % 60) | 0;

				minutes = minutes < 10 ? '0' + minutes : minutes;
				seconds = seconds < 10 ? '0' + seconds : seconds;

				display.textContent = minutes + ':' + seconds;

				if (diff <= 0) {

					// add one second so that the count down starts at the full duration
					// example 05:00 not 04:59
					start = Date.now() + 1000;
				}
			}

			// we don't want to wait a full second before the timer starts
			timer();
			setInterval(timer, 1000);
		}

		var updateProgressInfo = function(entry, current, total) {
			var currentEntryEmail = entry["Email Address"];
			var entriesLeft = total - current;
			var timeLeftinSeconds = ((total * config.cycle_duration) - (current * config.cycle_duration)) / 1000;

			progressBarDescription.innerHTML = 'Current Entry: ' + currentEntryEmail;
			entriesLeftDescription.innerHTML = entriesLeft;
			startTimer(timeLeftinSeconds, timeleftDescription);
		};

		var doneUploading = function() {
			progressBarDescription.innerHTML = '';
			progressBar.addClass('complete');
			pageTitle.innerHTML = 'We\'re done, skipper!';
			pageSubitle.innerHTML = 'Form data successfully uploaded to <a href="https://app.hubspot.com/forms/' + config.hubspotPortalID + '/' + config.hubspotFormID + '/submissions" target="_blank">Hubspot.</a> Or you can <a onclick="location.reload();" href="#">Submit another form</a>';
		};

		return {
			doneUploading: doneUploading,
			updateProgress: updateProgress
		};
	})();
})(hubspot, steps);
var init = (
	function() {
		// init application state
		core.changeState('navigation', 'block');
	}
)(core);;
</script>