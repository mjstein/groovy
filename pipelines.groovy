import java.util.Random
Random  rand = new Random()
int return_random(max=10){
  return rand.nextInt(max+1) 
}

node {
   stage 'QA'
   echo 'QA Stage:'
   def jobname="${env.JOB_NAME}"
   echo "check out for ${jobname}"
   git url: 'https://github.com/mjstein/mjs-kubernetes.git'
   stage 'Pre'
   echo 'Pre Stage'
   
   stage 'Prod Stage'
   echo "startin Prd"
   int i = return_random()
   if (dotests == 'true') {
     echo "${dotests} ${i}"
     stage 'Test'
     input "Proceed Test"
     step([$class: 'Fingerprinter', targets: '*'])
     echo 'Test Stage'
   }
}
