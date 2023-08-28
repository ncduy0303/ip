package duke.command;

import duke.exception.DukeException;
import duke.storage.Storage;
import duke.task.TaskList;
import duke.ui.Ui;

public class MarkAsDoneCommand extends Command {
    private final int index;

    public MarkAsDoneCommand(int index) {
        this.index = index;
    }

    @Override
    public void execute(TaskList tasks, Ui ui, Storage storage) throws DukeException {
        tasks.markAsDone(this.index);
        ui.showMarkTaskAsDone(tasks.get(this.index));
        storage.save(tasks.toFileString());
    }
}
