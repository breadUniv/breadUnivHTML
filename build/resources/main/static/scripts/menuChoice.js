        // titleMenu span:active
        document.addEventListener('DOMContentLoaded', function () {
        
            const titleMenus = document.querySelectorAll('.titleMenu span');

            titleMenus.forEach(function(item) {
                item.addEventListener('click', function() {
                    document.querySelectorAll('.titleMenu span.active').forEach(function (activeItem) {
                        activeItem.classList.remove('active');
                    });
                    item.classList.add('active');
                });
            });
        });

        //html
        // <div class="titleMenu">
        //     <span>개인정보수정</span>
        //     <span>시간표조회</span>
        //     <span>수강신청조회</span>
        //     <br><br>
        //     <hr>
        //     <br>
        // </div> <!-- titleMenu -->