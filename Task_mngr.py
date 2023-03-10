import datetime

class Task:
    def __init__(self, title, description, due_date=None):
        self.title = title
        self.description = description
        self.completed = False
        self.created_at = datetime.datetime.now()
        self.due_date = due_date

    def __repr__(self):
        return f"{self.title} ({'completed' if self.completed else 'incomplete'})"

class TaskList:
    def __init__(self, name):
        self.name = name
        self.tasks = []

    def add_task(self, task):
        self.tasks.append(task)

    def remove_task(self, task):
        self.tasks.remove(task)

    def complete_task(self, task):
        task.completed = True

    def incomplete_task(self, task):
        task.completed = False

    def get_completed_tasks(self):
        return [task for task in self.tasks if task.completed]

    def get_incomplete_tasks(self):
        return [task for task in self.tasks if not task.completed]

    def get_tasks_due_today(self):
        today = datetime.date.today()
        return [task for task in self.tasks if task.due_date == today]

class TaskManager:
    def __init__(self):
        self.task_lists = []

    def add_task_list(self, task_list):
        self.task_lists.append(task_list)

    def remove_task_list(self, task_list):
        self.task_lists.remove(task_list)

    def get_all_tasks(self):
        return [task for task_list in self.task_lists for task in task_list.tasks]

    def get_completed_tasks(self):
        return [task for task in self.get_all_tasks() if task.completed]

    def get_incomplete_tasks(self):
        return [task for task in self.get_all_tasks() if not task.completed]

    def get_tasks_due_today(self):
        today = datetime.date.today()
        return [task for task in self.get_all_tasks() if task.due_date == today]

# task usage
task_list = TaskList('My Task List')
task_list.add_task(Task('Finish Python project', 'Complete the Python project by next week', datetime.date(2023, 3, 3)))
task_list.add_task(Task('Buy groceries', 'Buy groceries for the week', datetime.date(2023, 2, 27)))
task_list.add_task(Task('Do laundry', 'Do laundry on Sunday'))

task_manager = TaskManager()
task_manager.add_task_list(task_list)

print("All tasks:", task_manager.get_all_tasks())
print("Incomplete tasks:", task_manager.get_incomplete_tasks())
print("Completed tasks:", task_manager.get_completed_tasks())
print("Tasks due today:", task_manager.get_tasks_due_today())
