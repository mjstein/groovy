import java.util.Random
Random  rand = new Random()
int return_random(rand, max=10){
  return rand.nextInt(max+1) 
}


String specify_stg(String name, Closure method){
  stage name
  echo "commencing stage ${name}"
}

node {
   def jobname="${env.JOB_NAME}"
   echo "check out for ${jobname}"
   git url: 'https://github.com/mjstein/mjs-kubernetes.git'

   specify_stg('QA')

   specify_stg('Pre')

   specify_stg('Prd')
   
   int i = return_random(rand)
   if (dotests == 'true') {
     echo "${dotests} ${i}"
     stage 'Test'
     input "Proceed Test"
     step([$class: 'Fingerprinter', targets: '*'])
     echo 'Test Stage'
   }
}
