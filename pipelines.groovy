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
  return {sh 'ls -a'}
}

node {

//   def jobname="${env.JOB_NAME}"
//   echo "check out for ${jobname}"
//   git url: 'https://github.com/mjstein/mjs-kubernetes.git'
    specify_stg('Qa' , get_from_git())
    specify_stg('Prd' , get_from_git())
}
