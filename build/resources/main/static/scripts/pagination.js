function toggleDropdown() {
    var dropdown = document.getElementById("myDropdown");
    dropdown.style.display = (dropdown.style.display === "block") ? "none" : "block";
}

  // 다른 곳을 클릭하면 드롭다운이 닫히도록 처리
//   window.onclick = function(event) {
//     if (!event.target.matches('.dropdown')) {
//       var dropdowns = document.getElementsByClassName("dropdown-content");
//       for (var i = 0; i < dropdowns.length; i++) {
//         var openDropdown = dropdowns[i];
//         var openDropdownStyle = window.getComputedStyle(openDropdown);

//         if (openDropdownStyle.display === "block") {
//           openDropdown.style.display = "none";
//         }
//       }
//     }
//   }

// 페이지 번호를 동적으로 생성하는 스크립트
var paginationContainer = document.getElementById("pagination");

function createPageButton(pageNumber) {
    var button = document.createElement("button");
    button.textContent = pageNumber;
    button.addEventListener("click", function() {
        // 페이지 버튼 클릭 시 실행할 동작을 여기에 추가
        alert("페이지 " + pageNumber + "으로 이동합니다.");
    });
    paginationContainer.appendChild(button);
}

// 1부터 5까지의 페이지 버튼 생성
for (var i = 1; i <= 5; i++) {
    createPageButton(i);
}