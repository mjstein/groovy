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

void get_from_git(){ 
  git url: 'https://github.com/mjstein/mjs-kubernetes.git'
}


node {
   def job_map = ['qa':echo 'blah'}]

   def jobname="${env.JOB_NAME}"
   echo "check out for ${jobname}"
   git url: 'https://github.com/mjstein/mjs-kubernetes.git'
   for (item in job_map){ specify_stg(item.key , item.value)}
//   specify_stg('QA', {echo "hello"})

//   specify_stg('Pre')

//   specify_stg('Prd')
   
//   int i = return_random(rand)
//   if (dotests == 'true') {
//     echo "${dotests} ${i}"
//     stage 'Test'
//     input "Proceed Test"
//     step([$class: 'Fingerprinter', targets: '*'])
//     echo 'Test Stage'
//   }
}
