document.addEventListener('DOMContentLoaded', function () {
    var imgUploadButton = document.getElementById('imgUploadButton');
    var imageUploadInput = document.getElementById('imageUploadInput');
    var imgContainer = document.querySelector('.img');

    var MAX_IMAGES = 5;
    var uploadedImages = 0;

    imgUploadButton.addEventListener('click', function () {
        imageUploadInput.click();
    });

    imageUploadInput.addEventListener('change', function () {
        var files = imageUploadInput.files;
        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            if (uploadedImages >= MAX_IMAGES) {
                alert('최대 ' + MAX_IMAGES + '장까지만 이미지를 등록할 수 있습니다.');
                break;
            }
            var img = document.createElement('img');
            img.src = URL.createObjectURL(file);
            imgContainer.appendChild(img);
            uploadedImages++;
            img.addEventListener('click', function () {
                imgContainer.removeChild(this);
                uploadedImages--;
            });
        }
    });
});

        
        
        //Image upload & delete
        // document.addEventListener('DOMContentLoaded', function () {

        //     editProfileButton.addEventListener('click', function () {
        //         imageUploadInput.click();
        //     });
        
        //     imageUploadInput.addEventListener('change', function () {
        //         const selectedFile = imageUploadInput.files[0];
        //         if (selectedFile) {
        
        //             const imageUrl = URL.createObjectURL(selectedFile);
        //             profileImage.src = imageUrl;
        //         }
        //     });
        
        //     deleteProfileButton.addEventListener('click', function () {
        //         profileImage.src = "/RESOURCES/IMAGE/profile/none.png";
        //     });
        // });

        // html
        // <div class="profileButton">
        //     <img src="/RESOURCES/IMAGE/profile/경진새.jpeg" alt="profileImage" id="profileImage">
        //     <input type="file" id="imageUploadInput" style="display: none;">
        //     <button id="editProfileButton">프로필수정</button>
        //     <button id="deleteProfileButton">프로필삭제</button>
        // </div>

