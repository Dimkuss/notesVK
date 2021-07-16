fun main(){
    NoteService.addNote(Note(title = "Privet",text = "Hi"))
    NoteService.addNote(Note(title = "Zdarova",text = "Privet"))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    NoteService.addComment(Comment(text = "комментарий к записи 2"), NoteService.getNoteById(2))

    NoteService.editNote(NoteService.getNoteById(1), "Заголовок 1 отредактирован",
        "Первая запись исправлена")
    NoteService.editNote(NoteService.getNoteById(2), "Заголовок 2 отредактирован",
        "2я запись исправлена")

    NoteService.addComment(Comment(text = "комментарий к комментарию"),
        NoteService.getNoteById(2).getCommentById(1))
    NoteService.addComment(Comment(text = "еще один комментарий к комментарию"),
        NoteService.getNoteById(2).getCommentById(1))
    NoteService.addComment(Comment(text = "и еще один комментарий к комментарию"),
        NoteService.getNoteById(2).getCommentById(1))

    NoteService.addComment(Comment(text = "комментарий к комментарию к комментарию"),
        NoteService.getNoteById(2).getCommentById(1).getCommentById(1))

    NoteService.editComment(NoteService.getNoteById(2).getCommentById(1),
        "комментарий к записи 2 отредактирован")
    NoteService.editComment(NoteService.getNoteById(2).getCommentById(1).getCommentById(1)
        .getCommentById(1), "комментарий к комментарию к комментарию отредактирован")

    println("-----После добавления и редактирования комментариев-----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))

    NoteService.deleteNote(2)

    println("-----После удаления записи 2-----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    try{
        println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))
    } catch(e: NoteIdNotFoundException) {
        println("Запись 2 отсутствует\n")
    }

    NoteService.restoreNote(2)

    println("-----После восстановления записи 2-----")

    println(NoteService.getNoteWithComments(NoteService.getNoteById(1)))
    println(NoteService.getNoteWithComments(NoteService.getNoteById(2)))

}

