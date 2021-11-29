import axios from 'axios';

const url = 'https://jsonplaceholder.typicode.com/todos/1';


interface Todo {
  id : number;
  title : string;
  completed : boolean;
}

axios.get(url).then( response => {
  //Response.data has propertiex of 
  //id
  //title
  //complete
  const todo = response.data as Todo;

  const id = todo.id;
  const title = todo.title;
  const completed = todo.completed;

  logTodo(id, title, completed);
 
});

const logTodo = (id: number, title : string, completed: boolean) =>{
  console.log(`
  The Todo with ID : ${id}
  has title : ${title}
  Is it finished? ${completed}`);
}

let point:{x:number; y: number} = {
  x:10,
  y:20
}

let logNumber  = (i : number):void => {
  console.log(i);
};

let app = "str";