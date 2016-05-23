import java.util.Random
Random  rand = new Random()
int return_random(rand, max=10){
  return rand.nextInt(max+1) 
}


void specify_stg(String name, Closure method){
  stage name
  echo "Commencing stage ${name}"
  method()
}

Closure get_from_git(){ 
  return {git url: 'https://github.com/mjstein/chmjs-monit.git'}
}

node {

    specify_stg('Qa' , get_from_git())
    if (dotests == 'true'){
      specify_stg('Test' , {sh 'ls -a'})
    }
    specify_stg('Prd' , {sh 'ls -a'})
}
