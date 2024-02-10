document.getElementById("add-btn").addEventListener("click", () => {
    
     const inputData = document.getElementById("inputcontent").value.trim();
     
     if(!inputData){
         console.log("Data not defined");
         alert("Input data empty !!")
         return;
     }
     
     let todolist = document.getElementById("ul-list");
 
     let listItem = document.createElement("li");
     listItem.textContent = inputData;

    const textSpan = document.createElement("span");
    textSpan.textContent = "";

 
     let deleteBtn = document.createElement("button");
     deleteBtn.textContent = "Delete"
 
     deleteBtn.addEventListener("click", () => {
        console.log("Clicking on delete button");
        listItem.remove();
     });

     let editBtn = document.createElement("Button");
     editBtn.textContent = "Edit"

     editBtn.addEventListener("click", () => {
        console.log("Editing button");
        const newText = prompt("Enter new content: ", listItem.textContent);
        if(newText !== null && newText.trim() !==""){
            listItem.textContent = newText;
            listItem.appendChild(editBtn);
            listItem.appendChild(deleteBtn);
            return;
        }
     });
 
     listItem.appendChild(textSpan);
     listItem.appendChild(editBtn);
     listItem.appendChild(deleteBtn);
     
     const list = document.querySelector(".ul-list");
     console.log("Adding item to list ..")
     list.appendChild(listItem);

     document.getElementById("inputcontent").value = "";
});