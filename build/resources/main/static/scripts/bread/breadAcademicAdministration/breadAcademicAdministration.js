

document.addEventListener("DOMContentLoaded", function() {
    var acButton = document.getElementById("acButton");
    
    acButton.addEventListener("click", function(event) {
        event.preventDefault(); // 페이지 이동 방지
        
        // 팝업 창 생성
        var popup = window.open("", "신청완료", "width=300,height=130,top=400,left=900");
        popup.document.write("<div style='text-align: center;'>신청완료!</p>");
        popup.document.write("<p id='countdown' style='color: red;'>1초 후에 자동으로 닫힙니다.</p></div>");
        popup.document.write("<button style='margin: 10px auto; display: block;' onclick='window.close()'>닫기</button>");
        
        // 3초 후에 팝업 창 닫기
        var countdown = 1;
        var countdownElement = popup.document.getElementById("countdown");
        var countdownInterval = setInterval(function() {
            countdown--;
            countdownElement.textContent = countdown + "초 후에 자동으로 닫힙니다.";
            countdownElement.style.color = "red"; // 빨간색으로 변경
            if (countdown <= 0) {
                clearInterval(countdownInterval);
                popup.close();
            }
        }, 1000);
    });
});
//-----------------------------------------------------------

// document.addEventListener("DOMContentLoaded", function() {
//     var noCounter = 1; // NO 번호 초기값 설정
    
//     // '신청' 버튼 클릭 시 이벤트 처리
//     document.getElementById("acButton").addEventListener("click", function() {
//         // 현재 날짜 가져오기
//         var currentDate = getCurrentDate();

//         // 학과 입력값 가져오기
//         var departmentInput = document.querySelector("input[name='department']").value;

//         // 신청구분 선택값 가져오기
//         var applicationTypeInput = document.querySelector("input[name='application_type']:checked");
//         var applicationType = applicationTypeInput ? applicationTypeInput.value : "";

//         // 신청기간 선택값 가져오기
//         var applicationSemesterYear = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(1)").value;
//         var applicationSemesterSemester = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(2)").value;
//         var applicationSemesterEndYear = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(3)").value;
//         var applicationSemesterEndSemester = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(4)").value;

//         // 기존의 빈 행 삭제
//         var empty_table = document.querySelector(".tbl_head01 tbody tr.empty_table");
//         if (empty_table) {
//             empty_table.remove();
//         }

//         // 행 생성 및 데이터 입력
//         var tblHead = document.querySelector(".tbl_head01 tbody");
//         var newRow = document.createElement("tr");
//         newRow.innerHTML = `
//             <td>${noCounter++}</td> <!-- NO 번호 증가 -->
//             <td>${getCurrentDate()}</td>
//             <td>${applicationSemesterYear}</td>
//             <td>${applicationSemesterSemester}</td>
//             <td>${applicationType}</td>
//             <td>${departmentInput}</td>
//             <td class="status">신청</td>
//             <td></td>
//         `;

//         tblHead.appendChild(newRow);
        
//         // '접수여부'가 '신청'인 경우에만 '취소하기' 버튼 추가
//         var statusCell = newRow.querySelector(".status");
//         if (statusCell.textContent === "신청") {
//             var cancelButton = document.createElement("button");
//             cancelButton.textContent = "취소하기";
//             cancelButton.classList.add("cancelButton");
//             newRow.lastElementChild.appendChild(cancelButton);
//         }
//     });

//     // '취소하기' 버튼 클릭 시 이벤트 처리
//     document.addEventListener("click", function(event) {
//         if (event.target.classList.contains("cancelButton")) {
//             var cancelButtonCell = event.target.parentElement;
//             var row = cancelButtonCell.parentElement;
//             var cancelButton = row.querySelector(".cancelButton");
//             var cancelDateCell = row.querySelector("td:last-child");
//             cancelButtonCell.removeChild(cancelButton); // 버튼 제거
//             cancelDateCell.textContent = getCurrentDate(); // 취소일자 업데이트
//         }
//     });

//     // 현재 날짜 반환 함수
//     function getCurrentDate() {
//         var date = new Date();
//         var year = date.getFullYear();
//         var month = String(date.getMonth() + 1).padStart(2, '0');
//         var day = String(date.getDate()).padStart(2, '0');
//         return `${year}-${month}-${day}`;
//     }
// });

document.addEventListener("DOMContentLoaded", function() {
    var noCounter = 1; // NO 번호 초기값 설정
    
    // '신청' 버튼 클릭 시 이벤트 처리
    document.getElementById("acButton").addEventListener("click", function() {
        // 현재 날짜 가져오기
        var currentDate = getCurrentDate();

        // 학과 입력값 가져오기
        var departmentInput = document.querySelector("input[name='department']").value;

        // 신청구분 선택값 가져오기
        var applicationTypeInput = document.querySelector("input[name='application_type']:checked");
        var applicationType = applicationTypeInput ? applicationTypeInput.value : "";

        // 신청기간 선택값 가져오기
        var applicationSemesterYear = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(1)").value;
        var applicationSemesterSemester = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(2)").value;
        var applicationSemesterEndYear = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(3)").value;
        var applicationSemesterEndSemester = document.querySelector("select[name='application_semester'][id='application_semester']:nth-child(4)").value;

        // 기존의 빈 행 삭제
        var emptyTable = document.querySelector(".tbl_head01 tbody tr td.empty_table");
        if (emptyTable) {
            emptyTable.remove();
        }

        // 행 생성 및 데이터 입력
        var tblHead = document.querySelector(".tbl_head01 tbody");
        var newRow = document.createElement("tr");
        newRow.innerHTML = `
            <td>${noCounter++}</td> <!-- NO 번호 증가 -->
            <td>${getCurrentDate()}</td>
            <td>${applicationSemesterYear}</td>
            <td>${applicationSemesterSemester}</td>
            <td>${applicationType}</td>
            <td>${departmentInput}</td>
            <td class="status">신청</td>
            <td></td>
        `;

        tblHead.appendChild(newRow);
        
        // '접수여부'가 '신청'인 경우에만 '취소하기' 버튼 추가
        var statusCell = newRow.querySelector(".status");
        if (statusCell.textContent === "신청") {
            var cancelButton = document.createElement("button");
            cancelButton.textContent = "취소하기";
            cancelButton.classList.add("cancelButton");
            newRow.lastElementChild.appendChild(cancelButton);
        }
    });

    // '취소하기' 버튼 클릭 시 이벤트 처리
    document.addEventListener("click", function(event) {
        if (event.target.classList.contains("cancelButton")) {
            var cancelButtonCell = event.target.parentElement;
            var row = cancelButtonCell.parentElement;
            var cancelButton = row.querySelector(".cancelButton");
            var cancelDateCell = row.querySelector("td:last-child");
            cancelButtonCell.removeChild(cancelButton); // 버튼 제거
            cancelDateCell.textContent = getCurrentDate(); // 취소일자 업데이트
        }
    });

    // 현재 날짜 반환 함수
    function getCurrentDate() {
        var date = new Date();
        var year = date.getFullYear();
        var month = String(date.getMonth() + 1).padStart(2, '0');
        var day = String(date.getDate()).padStart(2, '0');
        return `${year}-${month}-${day}`;
    }
});