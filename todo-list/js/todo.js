(function(){
    var doneList = document.querySelector("#doneList");
    var newTodoList = document.querySelector("#newTodoList");
    var data=[
        {title:"制作个人网页",done:false},
        {title:"深度学习数据分析",done:false},
        {title:"给琦琦妞准备元旦礼物",done:false},
        {title:"准备建模美赛",done:false},
        {title:"为自己拼命努力",done:true},
        {title:"学无止境，不要放松",done:true}
    ];
    for(var i = 0;i < data.length;i++){
        var todo=data[i];
        createTodoElement(todo);
    }
    function createTodoElement(todo){
        //动态创建标签
        var li=document.createElement("li");
        var a=document.createElement("a");
        var checkspan=document.createElement("span");
        var textspan=document.createElement("span"); 
        var text = document.createTextNode(todo.title);//获得内容
        //添加标签的class属性
        checkspan.setAttribute("class","checkbox");
        textspan.setAttribute("class","text");
        a.setAttribute("href","javascript:;");
        
        //将标签安装树状结构进行组合；
        textspan.appendChild(text);
        a.appendChild(checkspan);
        li.appendChild(a);
        li.appendChild(textspan);
        console.log(li);
        if(todo.done){
            doneList.appendChild(li);
        }else{
            newTodoList.appendChild(li);
        }

    }
    var input = document.querySelector("#inputText");
    
        // onkeydown onkeyup onkeypress
        input.onkeyup = function(event){
            console.log(event.keyCode);  // keyCode C:大写
            if(event.keyCode == 13) {
                // 1. 将输入的内容转化成li标签，放入ul
                var inputValue = input.value;
                if(inputValue.trim()) {
                    var todo = {title: inputValue, done:false};
                    createTodoElement(todo);
                }
                input.value = "";
            }
        }
    
        document.onclick = function(event){ 
            var ev = event.target;
            if(ev.getAttribute("class") == "checkbox") {     
                var li = ev.parentNode.parentNode;
                var ul = li.parentNode;
                if(ul.getAttribute("class") == "todoList done") {
                    newTodoList.appendChild(li);
                } else {
                    doneList.appendChild(li);
                }
                
    
            }
    
    
        }
        

})();