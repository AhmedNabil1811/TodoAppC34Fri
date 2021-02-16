package com.route.todoapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import com.route.base.BaseActivity
import com.route.todoapplication.database.TasksDataBase
import com.route.todoapplication.database.model.Task
import kotlinx.android.synthetic.main.activity_add_task.*

class AddTaskActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_task)
        setUpViews()
        add_btn.setOnClickListener{
            addTask()
        }
    }

    private fun setUpViews() {
        title_layout.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                title_layout.error=null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
        desc_layout.editText?.addTextChangedListener(object :TextWatcher{
            override fun afterTextChanged(s: Editable?) {
                desc_layout.error=null
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })
    }

    private fun addTask() {
        if(!validData()) return
        val taskTitle = title_layout.editText?.text.toString();
        val taskDesc = desc_layout.editText?.text.toString();
        val taskStatus = isCompleted.isChecked

        val task = Task(title=taskTitle,description = taskDesc,isCompleted =taskStatus )
        TasksDataBase.getInstance(applicationContext)
            .TasksDao()
            .insertTask(task)
        showDialoge(messageId = R.string.task_added_successfully,
        posActionName = R.string.ok,
            posAction = DialogInterface.OnClickListener { dialog, which ->
                dialog.dismiss()
                finish()
            },isCancelable = false
            )
    }

    private fun validData(): Boolean {
        var isValid = true
        if(title_layout.editText?.text.toString().isBlank()){
            title_layout.error = "please enter title"
            isValid=false
        }
        if(desc_layout.editText?.text.toString().isBlank()){
            desc_layout.error = "please enter desc"
            isValid=false
        }
        return isValid
    }
}