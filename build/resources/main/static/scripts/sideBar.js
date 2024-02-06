// // sideBarToggle
//     $(document).ready(function () {
//         $(".sideBarDropdown ul.sub").hide();
//         $(".sideBarDropdown ul.sideBarDropdownToggle li").click(function () {
//             $("ul", this).slideToggle("normal");
//         });
//     });

            // sideBarToggle
            document.addEventListener('DOMContentLoaded', function () {
                const sideBarItems = document.querySelectorAll('.sideBarDropdown ul.sideBarDropdownToggle li');
        
                sideBarItems.forEach(item => {
                    item.addEventListener('click', function () {
    
                    const toggleClass = 'toggled';
                    const isToggled = this.classList.contains(toggleClass);
            
                    if (!isToggled) {
                        this.classList.add(toggleClass);
                    } else {
                        this.classList.remove(toggleClass);
                    }
    
                        this.classList.add('active');
    
                        if(this.parentElement.previousElementSibling)
                            this.parentElement.previousElementSibling.classList.add('active')
    
                            // 선택된 아이템(this) 외의 다른 아이템(otherItem)에 active를 제거하고
                            // 다른 아이템의 a링크(children[0]) - 'active' remove
                            // this. 부모의 형제들을 모두 slideUp
                            // 내가 선택한 요소만 활성화
    
                        sideBarItems.forEach(otherItem => {
                            if (otherItem !== this) {
                                otherItem.classList.remove('active');
                                otherItem.children[0].classList.remove('active');
    
                                if(!this.parentElement.previousElementSibling) {
                                $("ul", otherItem).slideUp("normal");}
                            }
    
                            if(otherItem === this) {
                                otherItem.parentElement.parentElement.classList.add('active');
                            }
                        });
    
                        event.stopPropagation();
            
                        $("ul", this).slideToggle("normal");
                    });
                });
            });

        // html
        //    <div class="sideBarDropdown">

        //         <ul class="sideBarDropdownToggle">
        //             <li class="sideBarDropdownClick"><a href="#">마이페이지</a>
        //                 <ul class="subToggle"> 
        //                     <li><a href="#">개인정보수정</a></li>
        //                     <li><a href="#">시간표조회</a></li>
        //                     <li><a href="#">수강신청조회</a></li>
        //                 </ul>
        //             </li>
            
        //             <li class="sideBarDropdownClick"><a href="#">학사행정</a>
        //                 <ul class="subToggle">
        //                     <li><a href="#">휴학 및 자퇴신청</a></li> 
        //                 </ul>
        //             </li>

        //             <li class="sideBarDropdownClick"><a href="#">강의조회</a></li>
        //             <li class="sideBarDropdownClick"><a href="#">수강신청</a></li>
        //             <li class="sideBarDropdownClick"><a href="#">성적관리</a></li>

        //             <li class="sideBarDropdownClick"><a href="#">브레드에바란다</a>
        //                 <ul class="subToggle">
        //                     <li><a href="#">Q&A</a></li>
        //                     <li><a href="#">불편/건의사항</a></li> 
        //                 </ul>
        //             </li>

        //             <li class="sideBarDropdownClick"><a href="#">공지사항</a></li>

        //             <li class="sideBarDropdownClick"><a href="#">분실물</a></li>
        //         </ul>

        //     </div> <!-- sideBarDropdownToggle -->

        // </div> <!-- sideBarBackground --