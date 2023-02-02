



function comment(postId){
    alert("작동됨");
    console.log(postId);


}



//
//
//(function ($) {
//	'use strict';
//	/* ----------------------------------------------------------- */
//	/*  Site search
//	/* ----------------------------------------------------------- */
//
// // overlay search
//
//    $('.search_toggle').on('click', function(e) {
//        e.preventDefault();
//        $('.search_toggle').toggleClass('active');
//        $('.overlay').toggleClass('open');
//        setTimeout(function(){
//            $('.search-form .form-control').focus();
//        },400);
//
//    });
//
// // instafeed Js
//
// if (($('#instafeed').length) !== 0) {
//    var userId = $('#instafeed').attr('data-userId');
//    var accessToken = $('#instafeed').attr('data-accessToken');
//      var userFeed =  new Instafeed({
//      get: 'user',
//      userId: '8987997106',
//      resolution: 'standard_resolution',
//      accessToken: '8987997106.924f677.8555ecbd52584f41b9b22ec1a16dafb9',
//      limit: 4,
//      template: '<div class="instagram-post col-lg-3 col-md-3 col-sm-6 col-6" id="{{id}}" ><a href="{{link}}" target="_blank" ><img src="{{image}}" class="img-fluid w-100"/><div class="intsa-meta"><span>{{likes}}</span><span>{{comments}}</span></div></a></div>'
//
//      });
//    userFeed.run();
//  }
//
//
//
// // post gallery
//
//        $('.post_gallery').owlCarousel({
//            loop:true,
//            margin:1,
//            nav:true,
//            dots: false,
//            responsive:{
//                0:{
//                    items:1
//                },
//                600:{
//                    items:1
//                },
//                1000:{
//                    items:1
//                }
//            }
//        });
//
//
//
//	$('.post-slide').slick({
//		fade: true,
//    autplay:true
//	});
//
//	// magnific Popup iframe
//
//      $('.popup-youtube, .popup-vimeo, .popup-gmaps').magnificPopup({
//          disableOn: 300,
//          type: 'iframe',
//          mainClass: 'mfp-fade',
//          removalDelay: 160,
//          preloader: false,
//          fixedContentPos: false
//      });
//
//	// -----------------------------
//
//
//	/* ----------------------------------------------------------- */
//	/*  Scroll To Top
//	/* ----------------------------------------------------------- */
//	$(window).scroll(function () {
//		if ($(this).scrollTop() > 500) {
//			$('.scroll-to-top').fadeIn();
//		} else {
//			$('.scroll-to-top').fadeOut();
//		}
//	});
//
//})(jQuery);