import java.util.Random
Random  rand = new Random()
int return_random(rand, max=10){
  return rand.nextInt(max+1) 
}


void specify_stg(String name, String method){
  stage name
  echo "Commencing stage ${name}"
  evaluate(method)
}

String get_from_git(){ 
  return "sh 'ls -a'"
}


node {
   def job_map = ['qa':get_from_git(), 'pre':get_from_git(), 'prd':get_from_git()]

//   def jobname="${env.JOB_NAME}"
//   echo "check out for ${jobname}"
//   git url: 'https://github.com/mjstein/mjs-kubernetes.git'
   for (item in job_map){ specify_stg(item.key , item.value)}
}
