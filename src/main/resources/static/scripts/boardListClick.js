//     let message = '[[${message}]]';
//
//     if(message != null && message !== 'null') {
//     alert(message);
// }

    /* 게시글 리스트에서 해당 게시글에 마우스를 올릴 때에 대한 스타일 처리 */
    if (document.querySelectorAll("#listArea span")) {
    const $spans = document.querySelectorAll("#listArea span");
        for (let i = 0; i < $spans.length; i++) {

            $spans[i].onmouseenter = function() {
            this.parentNode.style.backgroundColor = "orangered";
            this.parentNode.style.cursor = "pointer";
        }

            $spans[i].onmouseout = function() {
            this.parentNode.style.backgroundColor = "black";
        }

            $spans[i].onclick = function() {
            const no = this.parentNode.children[0].value;
            location.href = "/Notice/breadNoticePage?no=" + no;
        }
    }
}
