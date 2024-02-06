document.addEventListener("click", function(event) {
    if (event.target && event.target.matches("#submitBtn")) {
        var board = event.target.closest('.board');
        
        var status = board.querySelector('input[name="attendanceStatus"]:checked');

        if (status) {
            var attendanceCount = {
                '출석': 0,
                '지각': 0,
                '조퇴': 0,
                '결석': 0
            };

            var lastAttendanceStatus = '';

            var attendanceStatuses = board.querySelectorAll('input[name="attendanceStatus"]');
            attendanceStatuses.forEach(function(radioButton) {
                if (radioButton.checked) {
                    if (lastAttendanceStatus !== radioButton.value) {
                        if (lastAttendanceStatus !== '') {
                            attendanceCount[lastAttendanceStatus]--;
                        }
                        attendanceCount[radioButton.value]++;
                        lastAttendanceStatus = radioButton.value;
                    }
                }
            });

            var radioContainer = board.querySelector("#radioContainer");
            radioContainer.innerHTML = "출석: " + attendanceCount['출석'] + "<p style='margin-right: 15px'></p>지각: " + attendanceCount['지각'] + "<p style='margin-right: 15px'></p>조퇴: " + attendanceCount['조퇴'] + "<p style='margin-right: 15px'></p>결석: " + attendanceCount['결석'];

            var totalAttendance = attendanceCount['출석'] + attendanceCount['지각'] + attendanceCount['조퇴'] + attendanceCount['결석'];
            var attendanceRateContainer = board.querySelector("#attendanceRate");
            attendanceRateContainer.textContent = ((attendanceCount['출석'] / totalAttendance) * 100).toFixed(2) + "%";

            attendanceStatuses.forEach(function(radioButton) {
                radioButton.disabled = true;
            });

            event.target.style.display = "none";
            board.querySelector("#modifyBtn").style.display = "inline-block";
        } else {
            alert("출석 상태를 선택하세요.");
        }
    }

    if (event.target && event.target.matches("#modifyBtn")) {
        var board = event.target.closest('.board');
        
        var attendanceStatuses = board.querySelectorAll('input[name="attendanceStatus"]');
        attendanceStatuses.forEach(function(radioButton) {
            radioButton.disabled = false;
        });

        event.target.style.display = "none";
        board.querySelector("#submitBtn").style.display = "inline-block";

        var radioContainer = board.querySelector("#radioContainer");
        radioContainer.innerHTML = '<label><input type="radio" name="attendanceStatus" value="출석"> 출석</label><label><input type="radio" name="attendanceStatus" value="지각"> 지각</label><label><input type="radio" name="attendanceStatus" value="조퇴"> 조퇴</label><label><input type="radio" name="attendanceStatus" value="결석"> 결석</label>';

        var attendanceRateContainer = board.querySelector("#attendanceRate");
        attendanceRateContainer.textContent = "";
    }
});
