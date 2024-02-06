// 수정 삭제
function applyEdit(editInput, commentText) {
    var editedText = editInput.value;
    commentText.textContent = editedText;
    editInput.replaceWith(commentText);

    console.log("댓글이 수정되었습니다.");
}

function editComment(button) {

    var editInput = document.createElement("input");
    editInput.setAttribute('type', 'text');
    editInput.classList.add("commentNewInput");
    
    var commentText;
    if (editInput.value === '') {
        commentText = button.previousSibling;
    } else {
        commentText = document.querySelector(".commentText span");
    }
    
    editInput.value = commentText.textContent.trim();

    editInput.addEventListener("keyup", function(event) {
        if (event.key === "Enter") {
            applyEdit(editInput, commentText);
        }
    });

    button.addEventListener("click", function(event) {
        var clickedButton = event.target;

        if (clickedButton.textContent.trim() === "수정") {
            applyEdit(editInput, commentText);
        }
    });
    
    commentText.replaceWith(editInput);
    
    editInput.focus();
}

function deleteComment(button) {
    var previousSibling = button.previousElementSibling;
    if (previousSibling) {
        var secondPreviousSibling = previousSibling.previousElementSibling;
        var nextSibling = button.nextElementSibling;
        if (secondPreviousSibling) {
            secondPreviousSibling.remove();
        }
        if (previousSibling) {
            previousSibling.remove();
        }
        if (nextSibling) {
            nextSibling.remove();
        }
        button.remove();
    }
}




// 등록 댓글생성
document.addEventListener("DOMContentLoaded", function() {
    var inputField = document.querySelector('.commentContainer input[type="text"]');
    var submitButton = document.querySelector('.commentContainer button[type="submit"]');
    

    inputField.addEventListener("keyup", function(event) {
        if (event.key === "Enter") {
            submitComment();
        }
    });
    
    submitButton.addEventListener("click", function(event) {
        event.preventDefault();
        submitComment();
    });
});

    function submitComment() {
        var inputText = document.querySelector('.commentContainer input[type="text"]').value;
        if (inputText.trim() === '') {
            return;
        }
        
        var targetElement = document.querySelector(".commentText");
        var paragraph = document.createElement("span");
        paragraph.textContent = '[김민하] '+ inputText;
        targetElement.appendChild(paragraph);
    
        var editButton = document.createElement("button");
        editButton.textContent = "수정";
        editButton.onclick = function(event) {

        var previousElement = event.target.previousElementSibling;

        if (previousElement && previousElement.tagName.toLowerCase() == 'span') {
            console.log('등록 수정버튼');
            console.log(event.target);
            editComment(this);
        }
    };
    
    var deleteButton = document.createElement("button");
    deleteButton.textContent = "삭제";
    deleteButton.onclick = function() {
        deleteComment(this);
    };
    
    targetElement.appendChild(editButton);
    targetElement.appendChild(deleteButton)
    targetElement.appendChild(document.createElement("br"));

    document.querySelector('.commentContainer input[type="text"]').value = '';
}
