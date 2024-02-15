$(document).ready(function() {
    // 서버에서 데이터를 가져오는 AJAX 요청을 보냅니다.
    $.ajax({
        url: 'your_backend_endpoint', // 데이터를 가져올 엔드포인트 URL
        method: 'GET', // 데이터를 가져올 HTTP 메서드 (GET, POST 등)
        dataType: 'json', // 가져온 데이터 형식 (JSON 등)
        success: function(response) {
            // AJAX 요청이 성공하면 서버에서 받은 데이터를 배열에 저장합니다.
            var tableData = response.data; // 서버 응답에서 데이터를 추출하여 저장합니다.
            
            // 선택 목록의 내용을 업데이트하는 함수를 호출합니다.
            addOptionsToSelect(tableData);
        },
        error: function(xhr, status, error) {
            // AJAX 요청이 실패한 경우 에러를 처리합니다.
            console.error('Error:', error);
        }
    });
    
    // 선택 목록에 옵션을 추가하는 함수를 정의합니다.
    function addOptionsToSelect(tableData) {
        var yearSemesterSelect = $('#yearSemesterSelect'); // 선택 목록의 jQuery 객체
        yearSemesterSelect.empty(); // 선택 목록의 내용을 초기화합니다.
        
        // "전체" 옵션을 추가합니다.
        yearSemesterSelect.append('<option value="list">전체</option>');
        
        // 서버에서 받은 데이터를 기반으로 선택 목록에 옵션을 추가합니다.
        $.each(tableData, function(index, data) {
            var optionText = data.year + '학년도 ' + data.semester;
            var optionValue = data.year + '-' + data.semester;
            yearSemesterSelect.append('<option value="' + optionValue + '">' + optionText + '</option>');
        });
    }
});
