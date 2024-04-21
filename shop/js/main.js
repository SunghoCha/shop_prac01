$(function(){
    var $searchBtn = $('.shopping_nav .search_btn'),
        $searchForm = $('header form');

    $searchBtn.click(function(){
        $searchForm.toggleClass('active');
     });

    // 슬라이드
    $('.main_slides ul').bxSlider();

    // 상품 수량 가격 변경
    var $quantity = $('.quantity'),
        $unitprice = $quantity.attr('data-unitprice')
        $qtyBtn = $quantity.find('span'),
        $qytInput = $quantity.find('input'),
        $targetTotal = $('.total_price .price');

        /* 
        $qtyBtn 클릭 시 그 요소가 class명 plus
        (참)이면 (플러스 클릭했으면)
        $qtyInput value 기존값에서 1증가
        거짓이면 (마이너스를 클릭했으면)
        $qtyInput value 기존값에서 1감소
        */ 
     $qtyBtn.click(function() {
        var currentCount = parseInt($qytInput.val());
        if ($(this).hasClass('plus')) {
            $qytInput.val(currentCount + 1);
        } else { 
            if (currentCount > 1) {
                $qytInput.val(currentCount - 1);
            }
        }
        //수량 * 단가 -> 변수 total에 저장하고 그걸 .price 값으로 변경
        var total = (currentCount * $unitprice).toLocaleString('kr');
        $targetTotal.text(total + '원');
     });
     // 카테고리 선택
    //  $('.list_filters input[type="checkbox"]').change(function() {
    //     if ($(this).is(':checked')) {
    //         $(this).next('.box').css({
    //             background: '#fff',
    //             border: '4px solid #2492ED'
    //         });
    //     } else {
    //         $(this).next('.box').css({
    //             background: '#edf0f2',
    //             border: 'none'
    //         });
    //     }
    // });
});//document ready function