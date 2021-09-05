$(function(){

    const appendTask = function(data){
        var taskCode = '<a href="#" class="task-link" data-id="' +
            data.id + '">' + data.name + '</a><br>';
        $('#task-list')
            .append('<div>' + taskCode + '</div>');
    };

    
    //Show adding task form
    $('#show-add-task-form').click(function(){
        $('#task-form').css('display', 'flex');
    });

    //Closing adding task form
    $('#task-form').click(function(event){
        if(event.target === this) {
            $(this).css('display', 'none');
        }
    });

    //Getting task
    $(document).on('click', '.task-link', function(){
        var link = $(this);
        var taskId = link.data('id');
        $.ajax({
            method: "GET",
            url: '/todoList/' + taskId,
            success: function(response)
            {
                var code = '<span>Год:' + response.year + '</span>';
                link.parent().append(code);
            },
            error: function(response)
            {
                if(response.status == 404) {
                    alert('Задача не найдена!');
                }
            }
        });
        return false;
    });

    //Adding task
    $('#save-task').click(function()
    {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "POST",
            url: '/todoList/',
            data: data,
            success: function(response)
            {
                $('#task-form').css('display', 'none');
                var task = {};
                task.id = response;
                var dataArray = $('#task-form form').serializeArray();
                for(i in dataArray) {
                    task[dataArray[i]['name']] = dataArray[i]['value'];
                }
                appendTask(task);
            }
        });
        return false;
    });

    //Deleting task
    $('#delete-task').click(function()
    {
        var data = $('#task-form form').serialize();
        $.ajax({
            method: "DELETE",
            url: '/todoList/',
            data: data,
            success: function(response)
            {
                $('#task-form').css('display', 'none');
                // var task = {};
                // task.id = response;
                // var dataArray = $('#task-form form').serializeArray();
                // for(i in dataArray) {
                //     task[dataArray[i]['name']] = dataArray[i]['value'];
                // }
                // appendTask(task);
            }
        });
        return false;
    });

});