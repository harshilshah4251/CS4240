" Vim syntax file
" Language:  Tiger

if exists("b:current_syntax")
    finish
endif

syn keyword tigerKeywords begin end type of if then endif else while do enddo for to break return var
syn keyword tigerTypes int fixedpt void array main function string
syn keyword tigerStdLib print printi flush getchar ord chr size substring concat not exit 

" ERROR for easily identifying lines with intentional errors in invalid code
syn keyword tigerTodo TODO FIXME XXX ERROR
syn region tigerComment start="/\*" end="\*/" contains=tigerTodo

" TODO fix support for 0 and 0.ddd but disallow 0d+ and 0d+.ddd
syn match tigerNumber '[0-9]\d*'
syn match tigerNumber '[0-9]\d*\.\d\d\?\d\?'
syn match tigerId '[a-zA-Z][a-zA-Z_0-9]*'

let b:current_syntax = "tiger"

hi def link tigerTodo       Todo
hi def link tigerComment    Comment
hi def link tigerTypes      Type
hi def link tigerKeywords   Keyword
hi def link tigerFunction   Type
hi def link tigerStdLib     Function
hi def link tigerNumber     Constant
