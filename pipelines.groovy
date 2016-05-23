import java.util.Random
Random  rand = new Random()
int return_random(rand, max=10){
  return rand.nextInt(max+1) 
}


void specify_stg(String name, Closure method = {}){
  stage name
  echo "Commencing stage ${name}"
  method()
}

Closure get_from_git(){ 
  return {echo "woo"}//{->git url: 'https://github.com/mjstein/mjs-kubernetes.git'}
}


node {
   def job_map = ['qa':get_from_git(), 'pre':get_from_git(), 'prd':get_from_git()]

   def jobname="${env.JOB_NAME}"
   echo "check out for ${jobname}"
   git url: 'https://github.com/mjstein/mjs-kubernetes.git'
   for (item in job_map){ specify_stg(item.key , item.value)}
}
