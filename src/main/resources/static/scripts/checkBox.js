// 체크박스
window.onload = function() {
    var boarderTitleCheckbox = document.getElementById("boarderTitleCheckbox");
    if (boarderTitleCheckbox) {
        boarderTitleCheckbox.addEventListener("change", function() {
            var isChecked = this.checked;
            var checkboxes = document.querySelectorAll(".boardCheckbox");
            checkboxes.forEach(function(checkbox) {
                checkbox.checked = isChecked;
            });
        });
    }
};

    // html
    // <div class="boardContainer">
    //     <div class="boarderTitle">
    //         <input type="checkbox" id="boarderTitleCheckbox">
    //         <span>글번호</span>
    //         <span class="title">글제목</span>
    //         <span>작성자</span>
    //         <span>조회수</span>
    //         <span>작성일</span>
    //     </div>
    //         <br><hr><br>    
            
    //     <div class="board">
    //         <input type="checkbox" class="boardCheckbox">
    //         <span>1</span>
    //         <span class="title">[공지사항] 빵 많이먹으면 배부르니까 조심하세요</span>
    //         <span>관리자</span>
    //         <span>2213</span>
    //         <span>2024-01-25</span>
    //     </div>
    // </div>